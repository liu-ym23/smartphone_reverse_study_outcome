package com.bytedance.bdp.appbase.base.bdptask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\t\b\u0016¢\u0006\u0004\b\u0013\u0010\u0014B\u0013\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0013\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007J \u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpHandler;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "msgToString", "trace", "Ljava/lang/Runnable;", "r", "", UGCMonitor.TYPE_POST, "", "uptimeMillis", "postAtTime", "sendMessageAtTime", "", "dispatchMessage", "name", "Ljava/lang/String;", "<init>", "()V", "Landroid/os/Handler$Callback;", "callback", "(Landroid/os/Handler$Callback;)V", "Landroid/os/Looper;", "looper", "(Landroid/os/Looper;)V", "(Landroid/os/Looper;Landroid/os/Handler$Callback;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public class BdpHandler extends Handler {
    public static final a Companion = null;
    private static final String MSG_ORIGIN_DATA_KEY = "__origin_bdp_handler_data__";
    private static final String MSG_PRE_TRACE_LIST_KEY = "__pre_trace_point_list__";
    private static final String MSG_TRACE_EVENT_KEY = "__trace_point_event_name__";
    public String name;

    public static final class a {
        public a() {
        }
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdpHandler f200406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Message f200407b;

        public b(BdpHandler r100, Message r101) {
            this.f200406a = r100;
            this.f200407b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            BdpHandler.m8304access$dispatchMessage$s458090724(this.f200406a, this.f200407b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a();
    }

    public BdpHandler() {
    }

    public BdpHandler(Handler.Callback r100) {
        super(r100);
    }

    private final String msgToString(Message r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100.getTarget() != null) goto L5;
        r101.append(" barrier=");
        r101.append(r100.arg1);
    L19:
        r101.append(" }");
        return r101.toString();
    L5:
        if (r100.getCallback() == null) goto L7;
        r101.append(" callback=");
        r101.append(r100.getCallback().getClass().getName());
    L9:
        if (r100.arg1 == 0) goto L12;
        r101.append(" arg1=");
        r101.append(r100.arg1);
    L12:
        if (r100.arg2 == 0) goto L15;
        r101.append(" arg2=");
        r101.append(r100.arg2);
    L15:
        if (r100.obj == null) goto L17;
        r101.append(" obj=");
        r101.append(r100.obj);
    L17:
        r101.append(" target=");
        r101.append(r100.getTarget().getClass().getName());
        goto L19
    L7:
        r101.append(" what=");
        r101.append(r100.what);
        goto L9
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message r100) {
        if (BdpTrace.ENABLE == false) goto L26;
        Bundle r101 = r100.peekData();
        LinkedList r102 = null;
        if (r101 == null) goto L7;
        Bundle r103 = r101.getBundle(MSG_ORIGIN_DATA_KEY);
    L8:
        if (r101 == null) goto L10;
        String r104 = r101.getString(MSG_TRACE_EVENT_KEY, null);
    L11:
        if (r101 == null) goto L15;
        ArrayList r105 = r101.getParcelableArrayList(MSG_PRE_TRACE_LIST_KEY);
        if (r105 == null) goto L15;
        r102 = new LinkedList(r105);
    L15:
        r100.setData(r103);
        String r106 = this.name;
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
        String r108 = "HdMsg";
    L25:
        BdpPool.directRun(r108 + ':' + r104, r102, new b(this, r100));
        return;
    L24:
        r108 = "HdMsg_" + this.name;
        goto L25
    L18:
        if (r106.length() == 0) goto L21;
        r107 = false;
        goto L22
    L10:
        r104 = null;
        goto L11
    L7:
        r103 = null;
        goto L8
    L26:
        super.dispatchMessage(r100);
    }

    public BdpHandler(Looper r100) {
        super(r100);
    }

    public BdpHandler(Looper r100, Handler.Callback r101) {
        super(r100, r101);
    }

    /* JADX INFO: renamed from: access$dispatchMessage$s-458090724, reason: not valid java name */
    public static final /* synthetic */ void m8304access$dispatchMessage$s458090724(BdpHandler r100, Message r101) {
        super.dispatchMessage(r101);
    }

    public final boolean post(String r100, Runnable r101) {
        if (BdpTrace.ENABLE == false) goto L13;
        if (r100 == null) goto L6;
        Message r102 = Message.obtain(this, r101);
        Bundle r103 = r102.getData();
        if (r103 == null) goto L11;
        r103.putString(MSG_TRACE_EVENT_KEY, r100);
    L11:
        return sendMessage(r102);
    L6:
        return post(r101);
    L13:
        return post(r101);
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message r100, long r101) {
        if (BdpTrace.ENABLE == false) goto L27;
        LinkedList r102 = new LinkedList();
        LinkedList<TracePoint> r103 = BdpTrace.a();
        if (r103 == null) goto L7;
        r102.addAll(r103);
    L7:
        Bundle r104 = new Bundle();
        Bundle r105 = r100.peekData();
        if (r105 == null) goto L11;
        r104.putBundle(MSG_ORIGIN_DATA_KEY, r105);
    L11:
        if (r105 == null) goto L14;
        String r106 = r105.getString(MSG_TRACE_EVENT_KEY, null);
        if (r106 == null) goto L14;
    L15:
        r104.putString(MSG_TRACE_EVENT_KEY, r106);
        String r107 = this.name;
        if (r107 != null) goto L18;
    L21:
        boolean r108 = true;
    L22:
        if (r108 == false) goto L24;
        String r109 = "SdMsg";
    L25:
        k.c(r102, new TracePoint(r109 + ':' + r106, "", 3));
        r104.putParcelableArrayList(MSG_PRE_TRACE_LIST_KEY, new ArrayList(r102));
        r100.setData(r104);
        goto L27
    L24:
        r109 = "SdMsg_" + this.name;
        goto L25
    L18:
        if (r107.length() == 0) goto L21;
        r108 = false;
    L14:
        r106 = msgToString(r100);
    L27:
        return super.sendMessageAtTime(r100, r101);
    }

    public final boolean postAtTime(String r100, Runnable r101, long r102) {
        if (BdpTrace.ENABLE == false) goto L5;
        if (r100 == null) goto L8;
        Message r103 = Message.obtain(this, r101);
        Bundle r104 = r103.getData();
        if (r104 == null) goto L13;
        r104.putString(MSG_TRACE_EVENT_KEY, r100);
    L13:
        return sendMessageAtTime(r103, r102);
    L8:
        return postAtTime(r101, r102);
    L5:
        return postAtTime(r101, r102);
    }
}
