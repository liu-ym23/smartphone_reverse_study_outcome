package com.ss.android.vesdk;

import android.util.Pair;
import com.bef.effectsdk.message.MessageCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.ttve.nativePort.TEEffectInterface;
import com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam;
import com.ss.android.vesdk.effect.IEffect;
import com.ss.android.vesdk.filterparam.VEBaseFilterParam;
import com.ss.android.vesdk.gesture.VEGesture;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VEEffect implements IEffect, MessageCenter.Listener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f455587k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, Class> f455588l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TEEffectInterface f455589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MessageCenter.Listener f455590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<VERecorder.VEFaceInfoCallback> f455591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, Integer[]> f455592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Integer> f455593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, Pair<VEBaseAlgorithmParam, Integer>> f455594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, Pair<VEBaseFilterParam, Integer>> f455595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f455596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<VELandMarkDetectListener> f455597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f455598j;

    public static final enum TEEffectEngineType extends Enum<TEEffectEngineType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TEEffectEngineType[] f455599a = null;
        public static final TEEffectEngineType amazing = null;
        public static final TEEffectEngineType normal = null;

        static {
            TEEffectEngineType r100 = new TEEffectEngineType("normal", 0);
            normal = r100;
            TEEffectEngineType r101 = new TEEffectEngineType("amazing", 1);
            amazing = r101;
            f455599a = new TEEffectEngineType[]{r100, r101};
        }

        public static TEEffectEngineType[] values() {
            return (TEEffectEngineType[]) f455599a.clone();
        }

        public static TEEffectEngineType valueOf(String r100) {
            return (TEEffectEngineType) r27.a.a(TEEffectEngineType.class, r100);
        }

        public TEEffectEngineType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TEEffectScene extends Enum<TEEffectScene> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TEEffectScene[] f455600a = null;
        public static final TEEffectScene faceInfo = null;
        public static final TEEffectScene skeleton = null;

        static {
            TEEffectScene r100 = new TEEffectScene("faceInfo", 0);
            faceInfo = r100;
            TEEffectScene r101 = new TEEffectScene("skeleton", 1);
            skeleton = r101;
            f455600a = new TEEffectScene[]{r100, r101};
        }

        public static TEEffectScene[] values() {
            return (TEEffectScene[]) f455600a.clone();
        }

        public static TEEffectScene valueOf(String r100) {
            return (TEEffectScene) r27.a.a(TEEffectScene.class, r100);
        }

        public TEEffectScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TEFlagType extends Enum<TEFlagType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TEFlagType[] f455601a = null;
        public static final TEFlagType arSlamBitmap = null;
        public static final TEFlagType arSlamContent = null;
        public static final TEFlagType arSlamLimit = null;
        public static final TEFlagType detectListenerFlag = null;
        public static final TEFlagType effectAlgorithmInfo = null;
        public static final TEFlagType faceExtFlag = null;
        public static final TEFlagType faceInfo = null;
        public static final TEFlagType landMarkDetectFlag = null;
        public static final TEFlagType skeletonDetectFlag = null;
        public static final TEFlagType smartBeautyFlag = null;
        public static final TEFlagType stickerRequestFlag = null;

        static {
            TEFlagType r100 = new TEFlagType("faceInfo", 0);
            faceInfo = r100;
            TEFlagType r101 = new TEFlagType("faceExtFlag", 1);
            faceExtFlag = r101;
            TEFlagType r102 = new TEFlagType("detectListenerFlag", 2);
            detectListenerFlag = r102;
            TEFlagType r103 = new TEFlagType("smartBeautyFlag", 3);
            smartBeautyFlag = r103;
            TEFlagType r104 = new TEFlagType("arSlamBitmap", 4);
            arSlamBitmap = r104;
            TEFlagType r105 = new TEFlagType("arSlamContent", 5);
            arSlamContent = r105;
            TEFlagType r110 = new TEFlagType("landMarkDetectFlag", 6);
            landMarkDetectFlag = r110;
            TEFlagType r111 = new TEFlagType("stickerRequestFlag", 7);
            stickerRequestFlag = r111;
            TEFlagType r112 = new TEFlagType("effectAlgorithmInfo", 8);
            effectAlgorithmInfo = r112;
            TEFlagType r113 = new TEFlagType("skeletonDetectFlag", 9);
            skeletonDetectFlag = r113;
            TEFlagType r114 = new TEFlagType("arSlamLimit", 10);
            arSlamLimit = r114;
            f455601a = new TEFlagType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static TEFlagType[] values() {
            return (TEFlagType[]) f455601a.clone();
        }

        public static TEFlagType valueOf(String r100) {
            return (TEFlagType) r27.a.a(TEFlagType.class, r100);
        }

        public TEFlagType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f455587k = VEEffect.class.getSimpleName();
        HashMap r100 = new HashMap();
        f455588l = r100;
        r100.put("filter in time offset", Integer.class);
    }

    public final void g() {
        ((CopyOnWriteArrayList) this.f455591c).clear();
        Set<Integer> r100 = this.f455593e;
        TEEffectScene r101 = TEEffectScene.faceInfo;
        ((HashSet) r100).remove(Integer.valueOf(r101.ordinal()));
        Integer[] r102 = (Integer[]) ((HashMap) this.f455592d).get(Integer.valueOf(r101.ordinal()));
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L9;
        int[] r104 = this.f455596h;
        int r105 = r102[r103].intValue();
        int r106 = r104[r105] - 1;
        r104[r105] = r106;
        if (r106 != 0) goto L8;
        Pair r107 = (Pair) ((HashMap) this.f455594f).get(r102[r103]);
        VELogUtil.d(f455587k, "remove track algorithm = " + ((VEBaseAlgorithmParam) r107.first).getAlgorithmName());
        removeTrackAlgorithm(((Integer) r107.second).intValue());
        ((HashMap) this.f455594f).remove(r102[r103]);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        TEBundle r108 = TEBundle.obtain();
        r108.setInt("effectInterfaceName", 10);
        r108.setInt("FlagType", TEFlagType.faceInfo.ordinal());
        r108.setInt(ForwardDependency$ForwardLocation.FLAG, 0);
        this.f455589a.callEffectInterface(r108);
        this.f455589a.setFaceInfoCallback(null);
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final void unregBachAlgorithmCallback() {
        this.f455589a.unregBachAlgorithmCallback();
    }

    public static boolean c() {
        return VEConfigCenter.getInstance().getValue("ve_enable_recorder_simply_project", false).booleanValue();
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final t0 getPreloadNodesResult() {
        TEBundle r100 = TEBundle.obtain();
        r100.setInt("effectInterfaceName", 62);
        TEBundle r101 = TEBundle.obtain();
        t0 r102 = new t0();
        if (this.f455589a.callEffectInterfaceWithResult(r100, r101) != 0) goto L5;
        r101.getLong("nodeNum");
        r101.getIntArray("effectIds");
        r101.getStringArray("paths");
    L5:
        return r102;
    }

    public VEEffect(TEEffectInterface r100) {
        HashMap r101 = new HashMap();
        this.f455592d = r101;
        this.f455593e = new HashSet();
        this.f455594f = new HashMap();
        this.f455598j = 0;
        this.f455589a = r100;
        r101.put(Integer.valueOf(TEEffectScene.faceInfo.ordinal()), new Integer[]{0, 1, 2});
        r101.put(Integer.valueOf(TEEffectScene.skeleton.ordinal()), new Integer[]{0, 3});
        this.f455596h = new int[32];
        int r102 = 0;
    L3:
        if (r102 >= 32) goto L5;
        this.f455596h[r102] = 0;
        r102 = r102 + 1;
        goto L3
    L5:
        MessageCenter.addListener(this);
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int cancelPreloadNodes(List<s0> r110) {
        TEBundle r100 = TEBundle.obtain();
        r100.setInt("effectInterfaceName", 61);
        r100.setInt("nodeSize", r110.size());
        long[] r101 = new long[r110.size()];
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r110.size()) goto L6;
        s0 r105 = (s0) ListProtector.get(r110, r104);
        r105.getClass();
        TEBundle r106 = TEBundle.obtain();
        r106.setBool("needReload", r105.f455920a);
        r106.setLong("reqId", 0);
        r106.setLong("priority", 0);
        r106.setLong("stickerId", 0);
        r106.setString("stickerPath", r105.f455921b);
        r106.setString("stickerTag", r105.f455922c);
        r101[r104] = r106.getHandle();
        r102.add(r106);
        r104 = r104 + 1;
        goto L4
    L6:
        r100.setLongArray("nodesHandle", r101);
        int r111 = this.f455589a.callEffectInterface(r100);
    L8:
        if (r103 >= r102.size()) goto L10;
        ((TEBundle) ListProtector.get(r102, r103)).recycle();
        r103 = r103 + 1;
        goto L8
    L10:
        return r111;
    }

    public final int e(VEGesture r100) {
        String r101 = lic.a.f509486a;
        VEGesture.a r102 = r100.f455839a;
        if (r102 == null) goto L13;
        TEBundle r103 = TEBundle.obtain();
        r103.setInt("processGestureEventType", r102.f455842a.ordinal());
        switch(lic.a.C6700a.f509487a[r102.f455842a.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L13;
        };
    L8:
        VEGesture.c r104 = (VEGesture.c) r102;
        r103.setFloat("rotation", r104.f455846b);
        r103.setFloat("factor", r104.f455847c);
    L14:
        if (r103 != null) goto L17;
        return -100;
    L17:
        r103.setInt("effectInterfaceName", 23);
        return this.f455589a.callEffectInterface(r103);
    L9:
        VEGesture.d r105 = (VEGesture.d) r102;
        r103.setFloat("scale", r105.f455848b);
        r103.setFloat("factor", r105.f455849c);
        goto L14
    L10:
        VEGesture.b r106 = (VEGesture.b) r102;
        r103.setFloat("x", r106.f455850b);
        r103.setFloat("y", r106.f455851c);
        r103.setFloat("dx", r106.f455843d);
        r103.setFloat("dy", r106.f455844e);
        r103.setFloat("factor", r106.f455845f);
        goto L14
    L11:
        VEGesture.f r107 = (VEGesture.f) r102;
        r103.setFloat("x", r107.f455850b);
        r103.setFloat("y", r107.f455851c);
        r103.setInt("gestureType", r107.f455852d.ordinal());
        goto L14
    L12:
        VEGesture.e r108 = (VEGesture.e) r102;
        r103.setFloat("x", r108.f455850b);
        r103.setFloat("y", r108.f455851c);
    L13:
        r103 = null;
        goto L14
    }

    public final void f(VERecorder.VEEffectAlgorithmCallback r100) {
        this.f455589a.setEffectAlgorithmInfoCallback(r100);
        TEBundle r101 = TEBundle.obtain();
        r101.setInt("effectInterfaceName", 10);
        r101.setInt("FlagType", TEFlagType.effectAlgorithmInfo.ordinal());
        if (r100 == null) goto L5;
        int r102 = 1;
    L6:
        r101.setInt(ForwardDependency$ForwardLocation.FLAG, r102);
        this.f455589a.callEffectInterface(r101);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final e0 getEffectFilterTime(long r100) {
        TEBundle r101 = TEBundle.obtain();
        r101.setInt("effectInterfaceName", 59);
        r101.setLong("sticker_id", r100);
        TEBundle r102 = TEBundle.obtain();
        if (this.f455589a.callEffectInterfaceWithResult(r101, r102) != 0) goto L5;
        e0 r103 = new e0();
        r102.getLong("beforeUpdateFilterTime");
        r102.getLong("updateFilterTime");
        r102.getLong("beforeEffectProcessTime");
        r102.getLong("effectProcessTime");
        r102.getLong("recorderDrawTime");
        r102.getLong("switchEffectTime");
    L6:
        r102.recycle();
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final void regBachAlgorithmCallback(List<VEBachAlgorithmCallback> r100) {
        this.f455589a.regBachAlgorithmCallback(r100);
        TEBundle r101 = TEBundle.obtain();
        r101.setInt("effectInterfaceName", 49);
        int[] r102 = new int[r100.size()];
        int r103 = 0;
    L4:
        if (r103 >= r100.size()) goto L6;
        r102[r103] = ((VEBachAlgorithmCallback) ListProtector.get(r100, r103)).getAlgorithmType().ordinal();
        r103 = r103 + 1;
        goto L4
    L6:
        r101.setIntArray("CallbackTypes", r102);
        this.f455589a.callEffectInterface(r101);
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int removeTrackAlgorithm(int r100) {
        TEBundle r101 = TEBundle.obtain();
        r101.setInt("effectInterfaceName", 8);
        r101.setInt("AlgorithmIndex", r100);
        this.f455589a.callEffectInterface(r101);
        return 0;
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int removeTrackFilter(int r100) {
        TEBundle r101 = TEBundle.obtain();
        r101.setInt("effectInterfaceName", 2);
        r101.setInt("effectEngineType", TEEffectEngineType.normal.ordinal());
        r101.setInt("FilterIndex", r100);
        return this.f455589a.callEffectInterface(r101);
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final void setARCoreParam(VEARCoreParam r100) {
        TEBundle r101 = TEBundle.obtain();
        r101.setBool("isEnableARCore", r100.isEnableARCore());
        r101.setInt("effectInterfaceName", 48);
        this.f455589a.callEffectInterface(r101);
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final void enableEffectWithCameraFacing(boolean r100, int r101) {
        TEBundle r102 = TEBundle.obtain();
        r102.setInt("effectInterfaceName", 23);
        r102.setInt("effectEngineType", TEEffectEngineType.normal.ordinal());
        r102.setBool("enableEffectWithCameraFacing", r100);
        r102.setInt("cameraFacing", r101);
        this.f455589a.callEffectInterface(r102);
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int updatePreloadNodes(List<s0> r100, r0 r101) {
        throw null;
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int updateTrackAlgorithmParam(int r100, VEBaseAlgorithmParam r101) {
        TEBundle r102 = TEBundle.obtain();
        r102.setInt("effectInterfaceName", 9);
        r102.setInt("AlgorithmIndex", r100);
        TEBundle r103 = lic.a.e(r101);
        if (r103 == null) goto L5;
        r102.setHandle("AlgorithmParam", r103.getHandle());
    L5:
        this.f455589a.callEffectInterface(r102);
        if (r103 == null) goto L10;
        r103.recycle();
        return 0;
    L10:
        return 0;
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int updateTrackFilterParam(int r100, VEBaseFilterParam r101) {
        TEBundle r102 = TEBundle.obtain();
        r102.setInt("effectInterfaceName", 4);
        r102.setInt("effectEngineType", TEEffectEngineType.normal.ordinal());
        r102.setInt("FilterIndex", r100);
        TEBundle r103 = lic.a.f(r101);
        if (r103 == null) goto L5;
        r102.setHandle("FitlerParam", r103.getHandle());
    L5:
        int r104 = this.f455589a.callEffectInterface(r102);
        if (r103 == null) goto L8;
        r103.recycle();
    L8:
        return r104;
    }

    public final int[] b(String r100, String r101, boolean r102) {
        TEBundle r103 = TEBundle.obtain();
        r103.setInt("effectInterfaceName", 26);
        r103.setInt("effectEngineType", TEEffectEngineType.normal.ordinal());
        r103.setString("newNodePath", r100);
        r103.setString("nodeKey", r101);
        r103.setBool("switchToGLThread", r102);
        TEBundle r104 = TEBundle.obtain();
        this.f455589a.callEffectInterfaceWithResult(r103, r104);
        int[] r105 = r104.getIntArray("checkComposerNodeExclusionRet");
        r104.recycle();
        return r105;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.vesdk.effect.IEffect
    public final <T> int setFilterParam(int r100, String r101, T r102) {
        TEBundle r103 = TEBundle.obtain();
        r103.setInt("FilterIndex", r100);
        r103.setInt("effectInterfaceName", 6);
        r103.setInt("effectEngineType", TEEffectEngineType.normal.ordinal());
        TEBundle r104 = TEBundle.obtain();
        if ("filter in time offset".equals(r101) == false) goto L5;
        r104.setInt(r101, ((Integer) r102).intValue() * 1000);
    L5:
        r103.setHandle("FitlerParam", r104.getHandle());
        int r105 = this.f455589a.callEffectInterface(r103);
        r104.recycle();
        return r105;
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int updateTrackFilterTime(int r100, int r101, int r102) {
        TEBundle r103 = TEBundle.obtain();
        r103.setInt("effectInterfaceName", 3);
        r103.setInt("effectEngineType", TEEffectEngineType.normal.ordinal());
        r103.setInt("FilterIndex", r100);
        r103.setInt("SequenceIn", r101);
        r103.setInt("SequenceOut", r102);
        return this.f455589a.callEffectInterface(r103);
    }

    public final void a(VEBaseAlgorithmParam r100, int r101, int r102, int r110) {
        Pair r103 = new Pair(r100, Integer.valueOf(addTrackAlgorithm(0, 0, r100, r101, r102)));
        ((HashMap) this.f455594f).put(Integer.valueOf(r110), r103);
        VELogUtil.d(f455587k, "add algorithm: " + r100.getAlgorithmName());
    }

    public final void d(int r100, int r101, int r102, String r103) {
        TEBundle r104 = TEBundle.obtain();
        r104.setInt("effectInterfaceName", 32);
        r104.setInt("messageType", r100);
        r104.setInt("arg1", r101);
        r104.setInt("arg2", r102);
        r104.setString("arg3", r103);
        this.f455589a.callEffectInterface(r104);
    }

    @Override // com.bef.effectsdk.message.MessageCenter.Listener
    public final void onMessageReceived(int r100, int r101, int r102, String r103) {
        if (r100 != 17) goto L5;
        d(r100, r101, r102, r103);
    L5:
        MessageCenter.Listener r104 = this.f455590b;
        if (r104 == null) goto L9;
        r104.onMessageReceived(r100, r101, r102, r103);
    L9:
        if (r100 != 58) goto L11;
    L12:
        d(r100, r101, r102, r103);
        return;
    L11:
        if (r100 == 72) goto L12;
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final void sendEffectMsg(int r100, long r101, long r102, byte[] r103) {
        TEBundle r104 = TEBundle.obtain();
        r104.setInt("effectInterfaceName", 50);
        r104.setInt("MsgID", r100);
        r104.setLong("ARG1", r101);
        r104.setLong("ARG2", r102);
        r104.setLong("BufSize", r103.length);
        ByteBuffer r105 = ByteBuffer.allocateDirect(r103.length);
        r105.put(r103);
        r104.setByteBuffer("ARG3", r105);
        this.f455589a.callEffectInterface(r104);
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int addTrackAlgorithm(int r100, int r101, VEBaseAlgorithmParam r102, int r103, int r104) {
        TEBundle r105 = TEBundle.obtain();
        r105.setInt("effectInterfaceName", 7);
        r105.setInt("TrackType", r100);
        r105.setInt("TrackIndex", r101);
        r105.setInt("SequenceIn", r103);
        r105.setInt("SequenceOut", r104);
        r105.setString("AlgorithmName", r102.getAlgorithmName());
        r105.setInt("AlgorithmType", r102.getAlgorithmType());
        r105.setBool("ForInit", r102.getForInit());
        TEBundle r106 = lic.a.e(r102);
        if (r106 == null) goto L5;
        r105.setHandle("AlgorithmParam", r106.getHandle());
    L5:
        int r107 = this.f455589a.callEffectInterface(r105);
        if (r106 == null) goto L8;
        r106.recycle();
    L8:
        return r107;
    }

    @Override // com.ss.android.vesdk.effect.IEffect
    public final int addTrackFilter(int r100, int r101, VEBaseFilterParam r102, int r103, int r104) {
        TEBundle r105 = TEBundle.obtain();
        r105.setInt("effectInterfaceName", 1);
        r105.setInt("effectEngineType", TEEffectEngineType.normal.ordinal());
        r105.setInt("TrackIndex", r101);
        r105.setInt("TrackType", r100);
        r105.setString("FilterName", r102.filterName);
        r105.setInt("SequenceIn", r103);
        r105.setInt("SequenceOut", r104);
        r105.setInt("FilterType", r102.filterType);
        r105.setInt("FilterDurType", r102.filterDurationType);
        TEBundle r106 = lic.a.f(r102);
        if (r106 == null) goto L5;
        r105.setHandle("FitlerParam", r106.getHandle());
    L5:
        Pair<VEBaseFilterParam, Integer> r107 = new Pair(r102, -1);
        Map<Integer, Pair<VEBaseFilterParam, Integer>> r108 = this.f455595g;
        if (r108 == null) goto L8;
        r108.put(Integer.valueOf(r102.filterType), r107);
    L8:
        int r109 = this.f455589a.callEffectInterface(r105);
        if (r106 == null) goto L16;
        r106.recycle();
    L16:
        JSONObject r110 = new JSONObject();     // Catch: JSONException -> L13
        r110.put("filterType", r102.filterType);     // Catch: JSONException -> L13
        r110.put("filterIndex", r109);     // Catch: JSONException -> L13
        r110.put("seqIn", r103);     // Catch: JSONException -> L13
        r110.put("seqOut", r104);     // Catch: JSONException -> L13
        r110.put("resultCode", r109);     // Catch: JSONException -> L13
        com.ss.android.ttve.monitor.c.a("vesdk_event_recorder_switch_effect", r110, "business");     // Catch: JSONException -> L13
    L15:
        return r109;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
