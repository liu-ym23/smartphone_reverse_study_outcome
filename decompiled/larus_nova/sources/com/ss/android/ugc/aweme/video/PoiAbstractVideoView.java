package com.ss.android.ugc.aweme.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.locallife.poi.newdetail.widget.trip.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/video/PoiAbstractVideoView;", "Landroid/widget/FrameLayout;", "", "visible", "", "setSurfaceVisibility", "", ITTVideoEngineEventSource.KEY_MUTE, "setMute", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public abstract class PoiAbstractVideoView extends FrameLayout {
    public abstract void a(o r100);

    public abstract void b(String r100, String r101, String r102);

    public abstract Boolean c();

    public abstract Boolean d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j(o r100);

    public abstract void k();

    public abstract void l();

    public abstract void setMute(boolean r100);

    public abstract void setSurfaceVisibility(int r100);

    public PoiAbstractVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public PoiAbstractVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
    }

    public PoiAbstractVideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
    }
}
