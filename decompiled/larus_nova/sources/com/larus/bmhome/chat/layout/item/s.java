package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f304603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f304604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f304605c;

    public s(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        FrameLayout.inflate(r100, R.layout.larus_widget_citation_item, this);
        this.f304603a = (TextView) findViewById(R.id.citation_index);
        this.f304604b = (SimpleDraweeView) findViewById(R.id.citation_icon);
        this.f304605c = (TextView) findViewById(R.id.citation_title);
    }
}
