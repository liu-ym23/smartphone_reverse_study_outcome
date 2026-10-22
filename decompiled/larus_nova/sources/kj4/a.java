package kj4;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Process;
import bk4.q;
import com.bytedance.dora.buds.BudsEvent;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLink;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dora.link.spp.DoraSppLink;
import com.bytedance.dora.offline.file.OfflineFileSyncEngine;
import com.bytedance.dora.offline.record.DoraOfflineRecord;
import com.bytedance.dora.voice.IDoraVoice;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kk4.c;
import mj4.f;
import mj4.h;
import org.json.JSONException;
import org.json.JSONObject;
import pk4.i;
import pk4.j;
import pk4.n;
import qk4.g;
import sk4.b;
import sk4.d;
import sk4.e;
import tk4.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IDoraLink, IDoraVoice {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f503705f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ak4.a f503706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f503707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f503708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final uj4.b f503709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final uk4.b f503710e;

    public static kk4.b f() {
        c r100 = c.a.f503794a;
        kk4.b r101 = r100.f503793a;
        if (r101 != null) goto L25;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (r100.f503793a == null) goto L13;
        kk4.b r102 = r100.f503793a;     // Catch: Throwable -> L11
        r102.getClass();     // Catch: Throwable -> L11
        kk4.b r103 = new kk4.b(r102.f503781a);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    L21:
        return r103;
    L13:
        kk4.b r104 = c.a();     // Catch: Throwable -> L11
        if (r104 == null) goto L18;
        r100.f503793a = r104;     // Catch: Throwable -> L11
        r103 = new kk4.b(r104.f503781a);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        goto L21
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L11
        ArrayList r105 = new ArrayList();
        r105.add("spp");
        r105.add("p2p");
        Boolean r106 = Boolean.TRUE;
        kk4.b.d r107 = new kk4.b.d(r106, r105);
        kk4.b.e r108 = new kk4.b.e(r106, Boolean.FALSE, "rtc", "preset", "spp");
        r103 = new kk4.b(new kk4.b.a(new kk4.b.C6566b(r107), new kk4.b.c(r108)));
        goto L21
    L25:
        return new kk4.b(r101.f503781a);
    }

    public static a g() {
        if (f503705f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f503705f != null) goto L9;
        f503705f = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f503705f;
    }

    public static void j() {
        OfflineFileSyncEngine r100 = OfflineFileSyncEngine.e.f204538a;
        long r101 = r100.f204512j.incrementAndGet();
        r100.d("account_changed");
        r100.b("account_changed");
        j.d("OfflineFileSyncEngine", "Offline file account generation changed, generation=" + r101);
    }

    public final byte[] A() {
        f r100 = this.f503708c;
        r100.f514229d.h(1, 4, n.b(1, 4, 1), new byte[]{1, 0});
        if (r100.f514234i != null) goto L7;
        return null;
    L7:
        return r100.f514234i;
    }

    public final byte B() {
        f r100 = this.f503708c;
        r100.f514229d.h(1, 4, n.b(1, 4, 5), new byte[]{5, 0});
        if (r100.f514231f != null) goto L5;
    L7:
        return -1;
    L5:
        if (r100.f514231f.length < 1) goto L7;
        return r100.f514231f[0];
    }

    public final int[] C() {
        f r100 = this.f503708c;
        r100.f514229d.i(1, 3, new byte[]{8, 0});
        DoraDevice r101 = r100.a(true);
        if (r101 == null) goto L10;
        int[] r102 = r101.wearState;
        if (r102 == null) goto L10;
        if (r102.length < 2) goto L10;
        return r102;
    L10:
        return new int[]{-1, -1};
    }

    public final int D() {
        f r100 = this.f503708c;
        r100.f514229d.h(1, 4, n.b(1, 4, 32), new byte[]{32, 0});
        byte[] r101 = r100.f514232g;
        if (r101 != null) goto L5;
    L7:
        return -1;
    L5:
        if (r101.length < 1) goto L7;
        return r101[0];
    }

    public final int b() {
        uk4.b r100 = this.f503710e;
        byte[] r101 = r100.f550490c;
        if (r101 != null) goto L6;
        return r100.b();
    L6:
        if (r101.length >= 1) goto L11;
        return -1;
    L11:
        return r101[0];
    }

    public final DoraDevice c() {
        return this.f503708c.a(true);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int clearAudioPlayer() {
        this.f503707b.clearAudioPlayer();
        return 0;
    }

    public final int d() {
        int r100 = this.f503708c.f514230e.get();
        j.d("DoraBuds", "DoraBuds.getBudsLowPowerState: " + r100);
        return r100;
    }

    public final int e() {
        f r100 = this.f503708c;
        if (r100.f514246u >= 0) goto L7;
        r100.f514229d.i(1, 4, new byte[]{27, 0});
        return r100.f514246u;
    L7:
        return r100.f514246u;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final List<DoraDevice> getDeviceList() {
        return this.f503706a.getDeviceList();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final List<DoraDevice> getDoraBindList() {
        return this.f503706a.getDoraBindList();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final long getDoraBondCount() {
        return this.f503706a.f4000a.f204474z;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final List<DoraDevice> getDoraList() {
        return this.f503706a.getDoraList();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int getDoraState() {
        return this.f503706a.getDoraState();
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final boolean getRtosPlayerSwitchState() {
        return this.f503707b.getRtosPlayerSwitchState();
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final boolean getRtosPlayerSwitchVisiable() {
        return this.f503707b.f542386p;
    }

    public final int h() {
        f r100 = this.f503708c;
        r100.getClass();
        int r101 = r100.d(BudsEvent.GET_ANTI_SOUND_LEAK_STATE);
        j.d("DoraBuds", "DoraBuds.isBudsAntiSoundLeakEnable, syncRet: " + r101 + ", result: " + r100.f514237l);
        if (r101 == 0) goto L5;
        return r101;
    L5:
        if (r100.f514237l == false) goto L7;
        return 1;
    L7:
        return 0;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final boolean hasDoraDevice() {
        return this.f503706a.hasDoraDevice();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int isReady() {
        return this.f503706a.isReady();
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int pauseAudioPlayer() {
        this.f503707b.pauseAudioPlayer();
        return 0;
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final e requestProtocolInfo() {
        return this.f503707b.requestProtocolInfo();
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int resumeAudioPlayer() {
        this.f503707b.resumeAudioPlayer();
        return 0;
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int sendAudioPlayerDataEnd() {
        return this.f503707b.sendAudioPlayerDataEnd();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int stopScan() {
        return this.f503706a.stopScan();
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final sk4.a takeConversationModeInfo() {
        return this.f503707b.takeConversationModeInfo();
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int takeVolAbs() {
        return this.f503707b.takeVolAbs();
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int takeVolLevel() {
        return this.f503707b.takeVolLevel();
    }

    public final int y() {
        f r100 = this.f503708c;
        r100.getClass();
        if (com.bytedance.dorax.kmp.c.f204762a.f473011b != 1) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L11;
        int r102 = com.bytedance.dorax.kmp.c.a(new il4.b.a());
        if (r102 == 0) goto L16;
        return r102;
    L16:
        return r100.f514236k;
    L11:
        byte[] r103 = {1, 0};
        DoraSppLink r104 = r100.f514229d.f4000a;
        r104.getClass();
        int r105 = r104.E(1, 5, n.c(1, 5, r103), 3, r103);
        if (r105 == 0) goto L15;
        return r105;
    L15:
        return r100.f514236k;
    L5:
        r101 = false;
        goto L6
    }

    public final byte z() {
        f r100 = this.f503708c;
        r100.getClass();
        if (com.bytedance.dorax.kmp.c.f204762a.f473011b != 1) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        com.bytedance.dorax.kmp.c.a(new il4.a.C6281a());
    L10:
        if (r100.f514233h != null) goto L12;
        return 0;
    L12:
        return r100.f514233h[0];
    L8:
        r100.f514229d.h(1, 4, n.b(1, 4, 11), new byte[]{11, 0});
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public a() {
        j.e("DoraAdapter", "AdapterCreateInstance11 : " + this + " ,Process_id : " + Process.myPid(), new Throwable());
        this.f503706a = ak4.a.d();
        b r100 = b.C7624b.f542395a;
        this.f503707b = r100;
        f r101 = f.b.f514251a;
        this.f503708c = r101;
        g r102 = uj4.b.f550325h;
        this.f503709d = uj4.b.C7891b.f550334a;
        uk4.b r103 = uk4.b.C7893b.f550494a;
        this.f503710e = r103;
        dk4.c r104 = dk4.c.a.f468994a;
        ((CopyOnWriteArraySet) r101.f514226a).add(r104);
        ak4.a.d().registerDoraLinkCallback(r104);
        r100.registerDoraVoiceCallback(r104);
        if (r101.f514249x.getAndSet(true) == true) goto L6;
        ak4.a.d().registerDoraLinkCallback(r101.f514248w);
    L6:
        if (r103.f550492e.getAndSet(true) == true) goto L8;
        ak4.a.d().registerDoraLinkCallback(r103.f550491d);
    L8:
        DoraOfflineRecord.getInstance().init();
        j.d("DoraAdapter", "AdapterCreateInstance22 : " + this);
    }

    public static void F(kk4.b r100) {
        c r101 = c.a.f503794a;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r100.d() == true) goto L11;
        j.d("DoraXLinkCommonConfigCenter", "updateConfig ignore empty config");     // Catch: Throwable -> L9
        monitor-exit(r101);
        return;
    L11:
        r101.f503793a = new kk4.b(r100.f503781a);     // Catch: Throwable -> L9
        i r102 = i.a.f529628a;     // Catch: Throwable -> L9
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
        kk4.b.a r104 = r100.f503781a;     // Catch: Throwable -> L9 JSONException -> L20
        if (r104 == null) goto L15;
        r103.put("Android", kk4.b.a.a(r104));     // Catch: Throwable -> L9 JSONException -> L20
    L15:
        String r105 = r103.toString();     // Catch: Throwable -> L9
        r102.f529627a.storeString("dora_x_link_common_config", r105);     // Catch: Throwable -> L9
        j.d("DoraXLinkCommonConfigCenter", "updateConfig success");     // Catch: Throwable -> L9
        monitor-exit(r101);
    }

    public final void E(h r100) {
        ((CopyOnWriteArraySet) this.f503708c.f514226a).remove(r100);
    }

    public final int a(int r100) {
        return this.f503708c.f514229d.i(1, 9, new byte[]{1, 1, (byte) r100});
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final DoraDevice convertScanResultToDoraDevice(ScanResult r100) {
        return this.f503706a.convertScanResultToDoraDevice(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final DoraDevice convertScanResultToDoraDeviceV2(ScanResult r100) {
        return this.f503706a.convertScanResultToDoraDeviceV2(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int getBtConnectState(DoraDevice r100) {
        return this.f503706a.getBtConnectState(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final DoraDevice getDoraDevice(String r100) {
        return this.f503706a.getDoraDevice(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int getDoraLinkState(DoraDevice r100) {
        return this.f503706a.getDoraLinkState(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final boolean hasAppBound(int r100) {
        return this.f503706a.hasAppBound(r100);
    }

    public final boolean i(int r100) {
        byte[] r101 = this.f503708c.f514234i;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.length != 0) goto L7;
        return false;
    L7:
        if ((r101.length % 4) != 0) goto L31;
        int r102 = 0;
    L11:
        if (r102 >= r101.length) goto L32;
        if (r101[r102] != r100) goto L21;
        if (r101[r102 + 1] != 0) goto L21;
        if (r101[r102 + 2] != 1) goto L21;
        if (r101[r102 + 3] != 34) goto L29;
        return true;
    L29:
        return false;
    L21:
        r102 = r102 + 4;
        goto L11
    L32:
        return false;
    L31:
        return false;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void initDoraSettingsConfig(String r100) {
        this.f503706a.initDoraSettingsConfig(r100);
    }

    public final void k(h r100) {
        ((CopyOnWriteArraySet) this.f503708c.f514226a).add(r100);
    }

    public final void l(uk4.c r100) {
        ((CopyOnWriteArraySet) this.f503710e.f550488a).add(r100);
    }

    public final int m(int r100) {
        return this.f503708c.f514229d.i(4, 7, new byte[]{6, 1, (byte) r100});
    }

    public final int n(boolean r100) {
        f r101 = this.f503708c;
        r101.getClass();
        if (r100 == false) goto L5;
        BudsEvent r102 = BudsEvent.ANTI_SOUND_LEAK_ON;
    L6:
        int r103 = r101.d(r102);
        if (r103 != 0) goto L13;
        boolean r104 = true;
        if (r100 == true) goto L12;
        r104 = false;
    L12:
        r101.f514237l = r104;
        j.d("DoraBuds", "DoraBuds.syncBudsAntiSoundLeakEnable.invoke updateBudsAntiSoundLeakState: " + (r100 ? 1 : 0));
    L13:
        j.d("DoraBuds", "DoraBuds.syncBudsAntiSoundLeakEnable, enable: " + r100 + ", ret: " + r103);
        return r103;
    L5:
        r102 = BudsEvent.ANTI_SOUND_LEAK_OFF;
        goto L6
    }

    public final int o(int r100) {
        f r101 = this.f503708c;
        r101.getClass();
        if (com.bytedance.dorax.kmp.c.f204762a.f473011b != 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return com.bytedance.dorax.kmp.c.a(new il4.a.b(r100));
    L9:
        return r101.f514229d.i(1, 4, new byte[]{11, 1, (byte) r100});
    L5:
        r102 = false;
        goto L6
    }

    public final int p(int r100) {
        return this.f503708c.f514229d.i(1, 6, new byte[]{8, 1, (byte) r100});
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int playPrompt(int r100) {
        DoraDevice r101 = c();
        if (r101 == null) goto L10;
        if (r100 >= 0) goto L6;
        return -5;
    L6:
        if (r100 <= r101.promptMax) goto L9;
        return -5;
    L9:
        return this.f503707b.playPrompt(r100);
    L10:
        return -5;
    }

    public final int q(String r100) {
        f r101 = this.f503708c;
        r101.getClass();
        if (r100.length() <= 0) goto L10;
        byte[] r102 = n.u(new String(r100.toCharArray()).getBytes(StandardCharsets.UTF_8), new byte[]{0});
        j.d("DoraBuds", "syncBudsName: " + r100 + " -" + Arrays.toString(r102) + "- " + r102.length);
        int r103 = r101.f514229d.i(1, 6, n.u(new byte[]{2, (byte) r102.length}, r102));
        if (r103 != 0) goto L12;
        DoraDevice r104 = r101.a(true);
        if (r104 == null) goto L9;
        r104.name = r100;
        i.a.f529628a.a(r104);
        return r103;
    L9:
        j.d("DoraBuds", "update keva name failed, due to current device is null");
        return r103;
    L12:
        return r103;
    L10:
        return -5;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerDoraLinkCallback(IDoraLinkCallback r100) {
        this.f503706a.registerDoraLinkCallback(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void registerDoraVoiceCallback(d r100) {
        this.f503707b.registerDoraVoiceCallback(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerETPProcessor(q r100) {
        this.f503706a.registerETPProcessor(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerHighPriorityDoraLinkCallback(IDoraLinkCallback r100) {
        this.f503706a.registerHighPriorityDoraLinkCallback(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int removeBindDevice(DoraDevice r100) {
        this.f503706a.removeBindDevice(r100);
        return 1;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int removeBond(DoraDevice r100) {
        return this.f503706a.removeBond(r100);
    }

    public final int s(boolean r100) {
        f r101 = this.f503708c;
        byte r102 = r100 ? 1 : 0;
        return r101.f514229d.j(3, 17, new byte[]{1, 1, r102}, 2000);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int scan(List<String> r100) {
        return this.f503706a.scan(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int sendAudioPlayerData(byte[] r100) {
        this.f503707b.sendAudioPlayerData(r100);
        return 0;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int sendETPPayload(byte[] r100) {
        return this.f503706a.sendETPPayload(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int setAudioPlayerConfig(l r100) {
        this.f503707b.setAudioPlayerConfig(r100);
        return 0;
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int setAudioPlayerVolume(float r100) {
        return this.f503707b.setAudioPlayerVolume(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void setRtosPlayerSwitchState(boolean r100) {
        this.f503707b.setRtosPlayerSwitchState(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void setRtosPlayerSwitchVisiable(boolean r100) {
        this.f503707b.f542386p = r100;
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int setVUI(int r100) {
        return this.f503707b.setVUI(r100, null);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int startVUI(int r100) {
        return this.f503707b.startVUI(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int stopConversationMode(int r100) {
        return this.f503707b.stopConversationMode(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int stopScan(ScanCallback r100) {
        return this.f503706a.stopScan(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int stopVUI(int r100) {
        return this.f503707b.stopVUI(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncPlayCommand(int r100) {
        return this.f503707b.syncPlayCommand(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void syncVUICommand(int r100) {
        this.f503707b.syncVUICommand(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void syncVUIData(byte[] r100) {
        this.f503707b.syncVUIData(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVUIError(int r100) {
        return this.f503707b.syncVUIError(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVUIEvent(sk4.g r100) {
        return this.f503707b.syncVUIEvent(r100, null);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVUIPreWakeUp(int r100) {
        return this.f503707b.syncVUIPreWakeUp(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVUIPreWakeUpEnable(int r100) {
        return this.f503707b.syncVUIPreWakeUpEnable(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVolCommand(int r100) {
        return this.f503707b.syncVolCommand(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVolLevel(int r100) {
        return this.f503707b.syncVolLevel(r100);
    }

    public final int t(String r100) {
        f r101 = this.f503708c;
        r101.getClass();
        byte[] r102 = r100.getBytes(StandardCharsets.UTF_8);
        return r101.f514229d.j(3, 17, n.u(new byte[]{2, (byte) r102.length}, r102), 2000);
    }

    public final int u(boolean r100) {
        return this.f503708c.f(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int unBond(DoraDevice r100) {
        return this.f503706a.unBond(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void unRegisterDoraVoiceCallback(d r100) {
        this.f503707b.unRegisterDoraVoiceCallback(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void unregisterDoraLinkCallback(IDoraLinkCallback r100) {
        this.f503706a.unregisterDoraLinkCallback(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void unregisterETPProcessor(q r100) {
        this.f503706a.unregisterETPProcessor(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void unregisterProtocolInfoCallback(sk4.c r100) {
        this.f503707b.unregisterProtocolInfoCallback(r100);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int updateVUIState(int r100) {
        return this.f503707b.updateVUIState(r100);
    }

    public final int v(boolean r100) {
        ak4.a r101 = this.f503708c.f514229d;
        byte r102 = r100 ? 1 : 0;
        return r101.j(1, 4, new byte[]{21, 2, r102, r102}, AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
    }

    public final int w(boolean r100) {
        return this.f503708c.g(r100);
    }

    public final int x(byte r100) {
        uk4.b r101 = this.f503710e;
        byte[] r102 = r101.f550490c;
        r101.f550490c = new byte[]{r100};
        int r103 = r101.f550489b.i(1, 4, new byte[]{6, 1, r100});
        if (r103 == 0) goto L5;
        r101.f550490c = r102;
    L5:
        return r103;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int connect(DoraDevice r100, String r101) {
        return this.f503706a.connect(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int disConnect(DoraDevice r100, int r101) {
        return this.f503706a.disConnect(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerDoraLinkCallback(IDoraLinkCallback r100, boolean r101) {
        this.f503706a.registerDoraLinkCallback(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final void registerProtocolInfoCallback(sk4.c r100, boolean r101) {
        this.f503707b.registerProtocolInfoCallback(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int removeBond(DoraDevice r100, int r101) {
        return this.f503706a.removeBond(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int scan(List<String> r100, ScanCallback r101) {
        return this.f503706a.scan(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int setVUI(int r100, byte[] r101) {
        return this.f503707b.setVUI(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int startConversationMode(int r100, int r101) {
        return this.f503707b.startConversationMode(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int startVUI(int r100, int r101) {
        return this.f503707b.startVUI(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int stopVUI(int r100, int r101) {
        return this.f503707b.stopVUI(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVUIError(int r100, Map<String, Object> r101) {
        return this.f503707b.syncVUIError(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVUIEvent(sk4.g r100, byte[] r101) {
        return this.f503707b.syncVUIEvent(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int syncVUIPreWakeUp(int r100, String r101) {
        return this.f503707b.syncVUIPreWakeUp(r100, r101);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int updateVUIState(int r100, int r101) {
        return this.f503707b.updateVUIState(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int connect(DoraDevice r100, String r101, ak4.b r102) {
        return this.f503706a.connect(r100, r101, r102);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int startScan(List<ScanFilter> r100, ScanSettings r101, ScanCallback r102) {
        return this.f503706a.startScan(r100, r101, r102);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int startVUI(int r100, int r101, int r102) {
        return this.f503707b.startVUI(r100, r101, r102);
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int commonTxSync(int r100, int r101, int r102, byte[] r103) {
        return this.f503707b.commonTxSync(r100, r101, r102, r103);
    }

    public final int r(int r100, int r101, int r102, int r103) {
        return this.f503708c.f514229d.i(1, 4, new byte[]{1, 4, (byte) r100, (byte) r101, (byte) r102, (byte) r103});
    }

    @Override // com.bytedance.dora.voice.IDoraVoice
    public final int setConversationMode(int r100, int r101, int r102, int r110, int r111) {
        return this.f503707b.setConversationMode(r100, r101, r102, r110, r111);
    }
}
