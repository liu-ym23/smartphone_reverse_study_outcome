package com.obric.sva.sdk.service;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.obric.sva.sdk.ipc.TrackAPI;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.InteractConst;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\bJ,\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\"\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupClientRegistry;", "", "tag", "", "<init>", "(Ljava/lang/String;)V", "clients", "", "", "Landroid/os/Messenger;", "deathRecipients", "Landroid/os/IBinder;", "Landroid/os/IBinder$DeathRecipient;", "bindClientDeath", "", "clientMessenger", "callback", "Lcom/obric/sva/sdk/service/WakeupClientRegistry$ClientDeathCallback;", "registerClient", "clientId", "deregisterClient", "", "sendResponse", "what", MapBundleKey.MapObjKey.OBJ_SL_OBJ, InteractConst.WAKEUP_SESSION_TYPE, "Lcom/obric/sva/sdk/session/SessionType;", "sendResponseToAllClients", "prepareDetectionBundle", "Landroid/os/Bundle;", "clear", "removeClientByMessenger", "unlinkDeathRecipient", "binder", "ClientDeathCallback", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupClientRegistry {
    private final Map<Integer, Messenger> clients;
    private final Map<IBinder, IBinder.DeathRecipient> deathRecipients;
    private final String tag;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupClientRegistry$ClientDeathCallback;", "", "onClientDeath", "", "clientToken", "Landroid/os/IBinder;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ClientDeathCallback {
        void onClientDeath(IBinder r100);
    }

    public final void clear() {
        Iterator<Map.Entry<IBinder, IBinder.DeathRecipient>> r100 = this.deathRecipients.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry<IBinder, IBinder.DeathRecipient> r101 = r100.next();
        r101.getKey().unlinkToDeath(r101.getValue(), 0);     // Catch: Exception -> L8
        goto L4
    L9:
        this.deathRecipients.clear();
        this.clients.clear();
    }

    public WakeupClientRegistry(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.tag = r100;
        this.clients = new HashMap();
        this.deathRecipients = new ArrayMap();
    }

    public static final /* synthetic */ Map access$getDeathRecipients$p(WakeupClientRegistry r100) {
        return r100.deathRecipients;
    }

    public static final /* synthetic */ String access$getTag$p(WakeupClientRegistry r100) {
        return r100.tag;
    }

    private final void removeClientByMessenger(Messenger r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<Integer, Messenger>> r102 = this.clients.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Integer, Messenger> r103 = r102.next();
        int r104 = r103.getKey().intValue();
        if (r103.getValue() != r100) goto L6;
        r101.add(Integer.valueOf(r104));
        goto L6
    L10:
        Iterator r105 = r101.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        int r106 = ((Number) r105.next()).intValue();
        this.clients.remove(Integer.valueOf(r106));
        goto L12
    L14:
        unlinkDeathRecipient(r100.getBinder());
    }

    private final void unlinkDeathRecipient(IBinder r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        IBinder.DeathRecipient r101 = this.deathRecipients.remove(r100);
        if (r101 != null) goto L11;
        return;
    L11:
        r100.unlinkToDeath(r101, 0);     // Catch: Exception -> L10
        return;
    }

    private final Bundle prepareDetectionBundle(int r100, Object r101) {
        if (r100 == 4353) goto L6;
        return null;
    L6:
        if ((r101 instanceof Bundle) == false) goto L8;
        Bundle r102 = (Bundle) r101;
    L9:
        if (r102 == null) goto L12;
        WakeProcessStartupEvidence.INSTANCE.attachTo(r102);
        return r102;
    L12:
        return null;
    L8:
        r102 = null;
        goto L9
    }

    public final void bindClientDeath(Messenger r100, final ClientDeathCallback r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100 != null) goto L5;
        return;
    L5:
        final IBinder r102 = r100.getBinder();
        unlinkDeathRecipient(r102);
        IBinder.DeathRecipient r103 = new WakeupClientRegistry$bindClientDeath$recipient$1(this, r101, r102);
        LogUtils.d(this.tag, "linkToDeath " + r102, new Object[0]);     // Catch: RemoteException -> L8
        r102.linkToDeath(r103, 0);     // Catch: RemoteException -> L8
        this.deathRecipients.put(r102, r103);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public final boolean deregisterClient(Messenger r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "clientMessenger");
        if (this.clients.containsValue(r100) == true) goto L5;
        return false;
    L5:
        if (this.clients.containsKey(Integer.valueOf(r101)) == true) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        this.clients.remove(Integer.valueOf(r101), r100);
    L10:
        unlinkDeathRecipient(r100.getBinder());
        return true;
    L9:
        this.clients.remove(Integer.valueOf(r101));
        goto L10
    }

    public final void registerClient(Messenger r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "clientMessenger");
        if (this.clients.containsKey(Integer.valueOf(r101)) == false) goto L17;
        LogUtils.d(this.tag, "handleRegisterClientReq containKey replace", new Object[0]);
        Messenger r102 = this.clients.get(Integer.valueOf(r101));
        if (r102 == null) goto L7;
        IBinder r103 = r102.getBinder();
    L8:
        IBinder r104 = r100.getBinder();
        if (r103 == null) goto L14;
        if (Intrinsics.areEqual(r103, r104) == true) goto L14;
        unlinkDeathRecipient(r103);
    L14:
        if (Build.VERSION.SDK_INT < 24) goto L16;
        this.clients.replace(Integer.valueOf(r101), r100);
        return;
    L16:
        Integer r105 = Integer.valueOf(r101);
        this.clients.put(r105, r100);
        return;
    L7:
        r103 = null;
        goto L8
    L17:
        LogUtils.d(this.tag, "handleRegisterClientReq not contain , just put it in", new Object[0]);
        Integer r106 = Integer.valueOf(r101);
        this.clients.put(r106, r100);
    }

    public final void sendResponseToAllClients(int r110, Object r111, SessionType r112) {
        LogUtils.v(this.tag, "sendResponseToAllClients to client size: " + this.clients.size(), new Object[0]);
        ArrayList r100 = new ArrayList(this.clients.entrySet());
        if (r110 != 4353) goto L21;
        Bundle r101 = prepareDetectionBundle(r110, r111);
        Iterator r113 = r100.iterator();
    L5:
        Messenger r102 = null;
        if (r113.hasNext() == false) goto L13;
        Object r103 = r113.next();
        boolean r104 = true;
        if (((Number) ((Map.Entry) r103).getKey()).intValue() == 1) goto L11;
        r104 = false;
    L11:
        if (r104 == false) goto L5;
    L14:
        Map.Entry r105 = (Map.Entry) r103;
        if (r105 == null) goto L17;
        r102 = (Messenger) r105.getValue();
    L17:
        if (r102 != null) goto L19;
        TrackAPI.trackWakeupInterrupted$default(r101, InteractConst.WAKEUP_INTERRUPTED_STAGE2, "voice interaction client unavailable", null, 8, null);
        return;
    L19:
        sendResponse(r102, r110, r101, r112);
        return;
    L13:
        r103 = null;
        goto L14
    L21:
        Iterator r106 = r100.iterator();
    L23:
        if (r106.hasNext() == false) goto L25;
        Map.Entry r107 = (Map.Entry) r106.next();
        int r108 = ((Number) r107.getKey()).intValue();
        Messenger r109 = (Messenger) r107.getValue();
        LogUtils.v(this.tag, "sendResponseToAllClients: key = " + r108 + " clientMessenger = " + r109 + " what = " + r110 + " obj = " + r111 + " hex-what is :" + Integer.toHexString(r110), new Object[0]);
        sendResponse(r109, r110, r111, r112);
        goto L23
    }

    public final void sendResponse(Messenger r100, int r101, Object r102, SessionType r110) {
        Bundle r103 = prepareDetectionBundle(r101, r102);
        if (r100 != null) goto L5;
    L16:
        LogUtils.v(this.tag, "sendResponse: invalid clientMessenger = " + r100, new Object[0]);
        if (4353 != r101) goto L24;
        TrackAPI.trackWakeupInterrupted$default(r103, InteractConst.WAKEUP_INTERRUPTED_STAGE2, "invalid clientMessenger", null, 8, null);
        return;
    L24:
        return;
    L5:
        if (this.clients.containsValue(r100) == false) goto L16;
        LogUtils.v(this.tag, "sendResponse: clientMessenger = " + r100 + " what =  " + r101 + " obj = " + r102 + " hex-what is :" + Integer.toHexString(r101), new Object[0]);     // Catch: RemoteException -> L12
        Message r111 = Message.obtain(null, r101);     // Catch: RemoteException -> L12
        if (4353 != r101) goto L9;
        r111.getData().putParcelable("data", r103);     // Catch: RemoteException -> L12
    L10:
        r100.send(r111);     // Catch: RemoteException -> L12
        return;
    L9:
        r111.obj = r102;     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        LogUtils.v(this.tag, "sendResponse: removing clientMessenger = " + r100, new Object[0]);
        e.printStackTrace();
        removeClientByMessenger(r100);
        if (4353 != r101) goto L22;
        TrackAPI.trackWakeupInterrupted(r103, InteractConst.WAKEUP_INTERRUPTED_STAGE2, "sendResponse RemoteException", e.getMessage());
        return;
    }
}
