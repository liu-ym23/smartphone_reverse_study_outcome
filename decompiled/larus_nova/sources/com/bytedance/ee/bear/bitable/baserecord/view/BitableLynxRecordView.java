package com.bytedance.ee.bear.bitable.baserecord.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import no4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0006\u0010 \u001a\u00020\u001dJ\b\u0010!\u001a\u00020\u001dH\u0002J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0006\u0010%\u001a\u00020\u001dJ\b\u0010&\u001a\u00020\u001dH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/baserecord/view/BitableLynxRecordView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/anniex/xbridge/sharerecord/ILynxShareRecordInterface;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isInit", "", "traceId", "", "isFirstSendEvent", "lynxViewHolder", "Lcom/bytedance/ee/bear/anniex/IBitableLarkLynxKitViewHolder;", "recordData", "Landroidx/lifecycle/MutableLiveData;", "recordToken", "mActivity", "Landroid/app/Activity;", "showStatusInterface", "Lcom/bytedance/ee/bear/bitable/anniex/xbridge/status/ILynxShowStatusInterface;", "recordDataObserver", "Landroidx/lifecycle/Observer;", "init", "", "activity", "token", "initView", "initRecordData", "sendEvent", "bridgeName", "dataJson", MapMonitorConst.EVENT_DESTROY, "closeShareRecord", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableLynxRecordView extends FrameLayout implements mo4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f207070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f207071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f207072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitableLynxViewHolder f207073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<String> f207074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f207075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f207076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f207077h;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableLynxRecordView f207078a;

        public b(BitableLynxRecordView r100) {
            this.f207078a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            tt5.a.h("BitableLynxRecordView", "recordDataObserver");
            BitableLynxRecordView r102 = this.f207078a;
            if (r102.f207072c == false) goto L5;
            r102.f207072c = false;
            tu4.b.f(r102.f207071b, "SHARE_RECORD_RENDER_LYNX_DATA_START", System.currentTimeMillis());
        L5:
            BitableLynxRecordView r103 = this.f207078a;
            r103.getClass();
            tt5.a.h("BitableLynxRecordView", "sendEvent: bridgeName:setRecordViewData");     // Catch: Throwable -> L10
            BitableLynxViewHolder r104 = r103.f207073d;     // Catch: Throwable -> L10
            if (r104 == null) goto L15;
            r104.k("setRecordViewData", r101);     // Catch: Throwable -> L10
            return;
        L15:
            return;
        L10:
            th = move-exception;
            tt5.a.e("BitableLynxRecordView", "sendEvent: ", th, false);
        }
    }

    static {
    }

    public BitableLynxRecordView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public BitableLynxRecordView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public BitableLynxRecordView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public BitableLynxRecordView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f207071b = "";
        this.f207072c = true;
        this.f207074e = new MutableLiveData();
        this.f207077h = new b(this);
    }
}
