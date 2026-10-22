package ww7;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class y0 implements Handler.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0 f561725c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f561726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<t0, a> f561727b;

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<s<?>> f561728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<s<?>> f561729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l f561730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HonorPushErrorEnum f561731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final t0 f561732e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ y0 f561733f;

        public final synchronized void d() {
            monitor-enter(this);
            i.g(this.f561733f.f561726a);     // Catch: Throwable -> L10
            this.f561731d = null;     // Catch: Throwable -> L10
            Iterator<s<?>> r100 = this.f561728a.iterator();     // Catch: Throwable -> L10
        L5:
            if (r100.hasNext() == false) goto L7;
            c(r100.next());     // Catch: Throwable -> L10
            goto L5
        L7:
            ((LinkedList) this.f561728a).clear();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final void a() {
            i.g(this.f561733f.f561726a);
            l r100 = this.f561730c;
            int r101 = r100.f561673a.get();
            if (r101 != 3) goto L5;
            r r102 = r100.f561676d;
            if (r102 == null) goto L11;
            r102.b();
        L11:
            r100.f561673a.set(1);
            return;
        L5:
            if (r101 != 5) goto L14;
            r100.f561673a.set(4);
            return;
        }

        public final synchronized void b(HonorPushErrorEnum r100) {
            monitor-enter(this);
            i.g(this.f561733f.f561726a);     // Catch: Throwable -> L13
            Iterator<s<?>> r101 = this.f561728a.iterator();     // Catch: Throwable -> L13
        L5:
            if (r101.hasNext() == false) goto L10;
            s<?> r102 = r101.next();     // Catch: Throwable -> L13
            ApiException r103 = r100.toApiException();     // Catch: Throwable -> L13
            if (r102.f561702a == null) goto L5;
            r102.a(r103, null);     // Catch: Throwable -> L13
            goto L5
        L10:
            ((LinkedList) this.f561728a).clear();     // Catch: Throwable -> L13
            this.f561731d = r100;     // Catch: Throwable -> L13
            a();     // Catch: Throwable -> L13
            Map<t0, a> r104 = this.f561733f.f561727b;     // Catch: Throwable -> L13
            ConcurrentHashMap r105 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L13
            r105.remove(this.f561732e);     // Catch: Throwable -> L13
            monitor-exit(this);
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public final synchronized void c(s<?> r100) {
            monitor-enter(this);
            ((LinkedList) this.f561729b).add(r100);     // Catch: Throwable -> L28
            l r101 = this.f561730c;     // Catch: Throwable -> L28
            b r102 = new b(r100);     // Catch: Throwable -> L28
            r100.getClass();     // Catch: Throwable -> L28
            Object r103 = null;
            Type r104 = r100.getClass().getGenericSuperclass();     // Catch: Exception -> L18 Throwable -> L28
            if (r104 == null) goto L11;
            Type r105 = ((ParameterizedType) r104).getActualTypeArguments()[0];     // Catch: Exception -> L18 Throwable -> L28
            if (r105 == null) goto L11;
            Class r106 = (Class) r105;     // Catch: Exception -> L18 Throwable -> L28
        L12:
            if (r106 != null) goto L14;
        L20:
            com.hihonor.push.sdk.h0 r107 = new com.hihonor.push.sdk.h0(r103, r102);     // Catch: Throwable -> L28
            IPushInvoke r108 = r101.f561674b;     // Catch: Throwable -> L28
            String r109 = r100.f561703b;     // Catch: Throwable -> L28
            RequestHeader r110 = r100.f561706e;     // Catch: Throwable -> L28
            IMessageEntity r111 = r100.f561704c;     // Catch: Throwable -> L28
            Bundle r112 = new Bundle();     // Catch: Throwable -> L28
            Bundle r113 = new Bundle();     // Catch: Throwable -> L28
            MessageCodec.formMessageEntity(r110, r112);     // Catch: Throwable -> L28
            MessageCodec.formMessageEntity(r111, r113);     // Catch: Throwable -> L28
            DataBuffer r114 = new DataBuffer(r109, r112, r113);     // Catch: Throwable -> L28
            if (r108 != null) goto L34;
        L26:
            monitor-exit(this);
            return;
        L34:
            r108.call(r114, r107);     // Catch: Exception -> L24 Throwable -> L28
        L24:
            e = move-exception;
            e.toString();     // Catch: Throwable -> L28
            goto L26
        L14:
            if (r106.isPrimitive() == true) goto L20;
            r103 = r106.newInstance();     // Catch: Exception -> L18 Throwable -> L28
        L11:
            r106 = null;
        L18:
            e = move-exception;
            k.a("In newResponseInstance, instancing exception." + e.getMessage());     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        }

        public a(y0 r100, t0 r101) {
            this.f561733f = r100;
            this.f561728a = new LinkedList();
            this.f561729b = new LinkedList();
            this.f561730c = new l(this);
            this.f561731d = null;
            this.f561732e = r101;
        }
    }

    public static class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s<?> f561734a;

        public b(s<?> r100) {
            this.f561734a = r100;
        }
    }

    static {
        f561725c = new y0();
    }

    public y0() {
        this.f561727b = new ConcurrentHashMap(5, 0.75f, 1);
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("HonorApiManager");
        ThreadMethodProxy.start(r100);
        this.f561726a = new Handler(r100.getLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        boolean r102 = false;
        if (r101 != 1) goto L84;
        s<?> r103 = (s) r100.obj;
        t0 r104 = r103.f561705d;
        a r105 = (a) ((ConcurrentHashMap) this.f561727b).get(r104);
        if (r105 != null) goto L7;
        r105 = new a(this, r104);
        ((ConcurrentHashMap) this.f561727b).put(r104, r105);
    L7:
        monitor-enter(r105);
        i.g(r105.f561733f.f561726a);     // Catch: Throwable -> L80
        l r106 = r105.f561730c;     // Catch: Throwable -> L80
        if (r106.f561673a.get() != 3) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r105.c(r103);     // Catch: Throwable -> L80
    L76:
        monitor-exit(r105);
        return true;
    L17:
        ((LinkedList) r105.f561728a).add(r103);     // Catch: Throwable -> L80
        HonorPushErrorEnum r108 = r105.f561731d;     // Catch: Throwable -> L80
        if (r108 != null) goto L20;
    L22:
        monitor-enter(r105);     // Catch: Throwable -> L80
        i.g(r105.f561733f.f561726a);     // Catch: Throwable -> L29
        l r109 = r105.f561730c;     // Catch: Throwable -> L29
        if (r109.f561673a.get() != 3) goto L26;
    L31:
        boolean r110 = true;
    L32:
        if (r110 == false) goto L35;
    L75:
        monitor-exit(r105);     // Catch: Throwable -> L80
        goto L76
    L35:
        if (r105.f561730c.f561673a.get() != 5) goto L37;
        boolean r111 = true;
    L38:
        if (r111 == true) goto L75;
        l r112 = r105.f561730c;     // Catch: Throwable -> L29
        r112.getClass();     // Catch: Throwable -> L29
        int r113 = r112.f561673a.get();     // Catch: Throwable -> L29
        if (r113 == 3) goto L75;
        if (r113 == 5) goto L75;
        if (r113 == 4) goto L75;
        c0 r114 = c0.f561643e;     // Catch: Throwable -> L29
        int r115 = i.j(r114.a());     // Catch: Throwable -> L29
        if (r115 != HonorPushErrorEnum.SUCCESS.getErrorCode()) goto L74;
        r112.f561673a.set(5);     // Catch: Throwable -> L29
        xw7.a r116 = i.f(r114.a());     // Catch: Throwable -> L29
        r r117 = new r(r116);     // Catch: Throwable -> L29
        r112.f561676d = r117;     // Catch: Throwable -> L29
        r117.f561697a = new j(r112);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r116.f565260c) == false) goto L51;
        if (TextUtils.isEmpty(null) == false) goto L51;
    L53:
        if (r102 == true) goto L55;
        Objects.toString(r116);     // Catch: Throwable -> L29
        r117.a(8002004);     // Catch: Throwable -> L29
        goto L75
    L55:
        Intent r118 = new Intent();     // Catch: Throwable -> L29
        String r119 = r116.f565258a;     // Catch: Throwable -> L29
        String r120 = r116.f565260c;     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r120) == true) goto L58;
        r118.setComponent(new ComponentName(r119, r120));     // Catch: Throwable -> L29
    L59:
        Object r121 = r.f561696d;     // Catch: Throwable -> L29
        monitor-enter(r121);     // Catch: Throwable -> L29
    L71:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L62:
        if (r114.a().bindService(r118, r117, 1) == false) goto L68;
        Handler r122 = r117.f561698b;     // Catch: Throwable -> L71
        if (r122 == null) goto L66;
        r122.removeMessages(1001);     // Catch: Throwable -> L71
    L67:
        r117.f561698b.sendEmptyMessageDelayed(1001, 10000);     // Catch: Throwable -> L71
    L69:
        monitor-exit(r121);     // Catch: Throwable -> L71
    L66:
        r117.f561698b = new Handler(Looper.getMainLooper(), new o(r117));     // Catch: Throwable -> L71
        goto L67
    L68:
        r117.f561699c = true;     // Catch: Throwable -> L71
        r117.a(8002001);     // Catch: Throwable -> L71
        goto L69
    L58:
        r118.setAction(null);     // Catch: Throwable -> L29
        r118.setPackage(r119);     // Catch: Throwable -> L29
    L51:
        if (TextUtils.isEmpty(r116.f565258a) == true) goto L53;
        r102 = true;
        goto L53
    L74:
        r112.a(r115);     // Catch: Throwable -> L29
        goto L75
    L37:
        r111 = false;
        goto L38
    L26:
        if (r109.f561673a.get() == 4) goto L31;
        r110 = false;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L80
    L20:
        if (r108.getErrorCode() == 0) goto L22;
        r105.b(r105.f561731d);     // Catch: Throwable -> L80
        goto L76
    L11:
        if (r106.f561673a.get() == 4) goto L14;
        r107 = false;
    L80:
        th = move-exception;
        throw th;
    L84:
        if (r101 != 2) goto L103;
        s r123 = (s) r100.obj;
        t0 r124 = r123.f561705d;
        if (r124 != null) goto L88;
    L102:
        return true;
    L88:
        if (((ConcurrentHashMap) this.f561727b).containsKey(r124) == false) goto L102;
        a r125 = (a) ((ConcurrentHashMap) this.f561727b).get(r124);
        if (r125 == null) goto L102;
        monitor-enter(r125);
        ((LinkedList) r125.f561729b).remove(r123);     // Catch: Throwable -> L99
        if (((LinkedList) r125.f561728a).peek() != null) goto L95;
    L96:
        r125.a();     // Catch: Throwable -> L99
        Map<t0, a> r126 = r125.f561733f.f561727b;     // Catch: Throwable -> L99
        ConcurrentHashMap r127 = (ConcurrentHashMap) r126;     // Catch: Throwable -> L99
        r127.remove(r125.f561732e);     // Catch: Throwable -> L99
    L97:
        monitor-exit(r125);
        goto L102
    L95:
        if (((LinkedList) r125.f561729b).peek() != null) goto L97;
    L99:
        th = move-exception;
        throw th;
    L103:
        return false;
    }
}
