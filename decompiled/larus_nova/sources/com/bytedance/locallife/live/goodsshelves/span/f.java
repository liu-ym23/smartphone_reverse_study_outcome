package com.bytedance.locallife.live.goodsshelves.span;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.bytedance.dux.text.DuxTextView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f259887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f259888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextView f259889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f259890d;

    @Override // com.bytedance.locallife.live.goodsshelves.span.d
    public final void onCancel(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f259888b.f259891a.remove(r100);
        this.f259889c.removeOnAttachStateChangeListener(this.f259890d);
    }

    @Override // com.bytedance.locallife.live.goodsshelves.span.d
    public final void onFailed(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f259887a.onFailed();
        this.f259888b.f259891a.remove(r100);
        this.f259889c.removeOnAttachStateChangeListener(this.f259890d);
    }

    @Override // com.bytedance.locallife.live.goodsshelves.span.d
    public final void a(String r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        this.f259887a.onSuccess(r101);
        this.f259888b.f259891a.remove(r100);
        this.f259889c.removeOnAttachStateChangeListener(this.f259890d);
    }

    public f(h r100, g r101, DuxTextView r102, b r103) {
        this.f259887a = r100;
        this.f259888b = r101;
        this.f259889c = r102;
        this.f259890d = r103;
    }
}
