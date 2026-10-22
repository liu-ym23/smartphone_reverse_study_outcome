package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LKUIRoundedImageView2 f416183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUIRoundedImageView2 f416184b;

    public final LKUIRoundedImageView2 getThumbImage() {
        return this.f416183a;
    }

    public final LKUIRoundedImageView2 getThumbImageMask() {
        return this.f416184b;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(r100).inflate(R.layout.doc_framelayout, this, true);
        this.f416183a = (LKUIRoundedImageView2) findViewById(R.id.doc_bear_thumbImage);
        this.f416184b = (LKUIRoundedImageView2) findViewById(R.id.doc_bear_image_mask);
    }
}
