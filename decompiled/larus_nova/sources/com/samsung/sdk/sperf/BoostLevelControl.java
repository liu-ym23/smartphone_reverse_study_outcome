package com.samsung.sdk.sperf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
class BoostLevelControl {
    public static final int BOOST_TYPE_NUM = 11;
    private static int boostResourceCount;
    private static BoostResource[] boostResources;
    private static BoostLevelControl instance;
    private static boolean isBoostLevelIntialized;
    private HashMap<Integer, BoostObject> scenarioBoostObjectMap;

    static {
        boostResources = new BoostResource[11];
    }

    private BoostLevelControl(SessionControl r110) {
        this.scenarioBoostObjectMap = new HashMap();
        int[] r100 = {64532198, 64532198, 64532198, 64532198, 64532198};
        int[] r101 = {64532198, 64532198, 64532198, 64532198, 64532198};
        int[] r102 = {64532198, 64532198, 64532198, 64532198, 64532198};
        int[] r103 = {64532198, 64532198, 64532198, 64532198, 64532198};
        int[] r104 = {64532198, 64532198, 64532198, 64532198, 64532198};
        int[] r105 = {64532198, 64532198, 64532198, 64532198, 64532198};
        int[] r111 = {0, 4};
        int[] r112 = {-20, -10, 0, 10, 20};
        int r113 = -1;
        DataOutputStream r114 = r110.getDataOutputStream();     // Catch: IOException -> L37
        DataInputStream r115 = r110.getDataInputStream();     // Catch: IOException -> L37
        if (r114 == null) goto L36;
        if (r115 == null) goto L51;
        r114.writeInt(Integer.reverseBytes(10));     // Catch: IOException -> L37
        r114.flush();     // Catch: IOException -> L37
        Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L37
        Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L37
        Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L37
        int r106 = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L37
        if (r106 != (-1)) goto L10;
        r106 = 99999999;
    L10:
        int r116 = 0;
    L11:
        if (r116 >= 5) goto L15;
        r100[r116] = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L13
        r116 = r116 + 1;     // Catch: IOException -> L13
    L13:
        e = e;
        r113 = r106;
    L38:
        e.printStackTrace();
    L39:
        setBoostResource(6, r111, r113);
        setBoostResource(7, r111, 99999999);
        setBoostResource(8, new int[]{70, 74, 30}, r113);
        setBoostResource(9, r112, r113);
        setBoostResource(10, new int[]{1}, r113);
        boostResources[8].setDefaultLevel(0);
        boostResources[9].setDefaultLevel(2);
        initScenarioBoostObject();
        isBoostLevelIntialized = true;
        return;
    L15:
        int r117 = 0;
    L16:
        if (r117 >= 5) goto L18;
        r102[r117] = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L13
        r117 = r117 + 1;     // Catch: IOException -> L13
        goto L16
    L18:
        int r118 = 0;
    L19:
        if (r118 >= 5) goto L21;
        r104[r118] = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L13
        r118 = r118 + 1;     // Catch: IOException -> L13
        goto L19
    L21:
        setBoostResource(0, r100, r106);     // Catch: IOException -> L13
        setBoostResource(2, r102, r106);     // Catch: IOException -> L13
        setBoostResource(4, r104, r106);     // Catch: IOException -> L13
        int r107 = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L13
        int r108 = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L13
        int r119 = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L13
        int r109 = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L13
        if (r109 != (-1)) goto L24;
        r113 = 99999999;
    L25:
        int r120 = 0;
    L26:
        if (r120 >= 5) goto L28;
        r101[r120] = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L37
        r120 = r120 + 1;     // Catch: IOException -> L37
        goto L26
    L28:
        int r121 = 0;
    L29:
        if (r121 >= 5) goto L31;
        r103[r121] = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L37
        r121 = r121 + 1;     // Catch: IOException -> L37
        goto L29
    L31:
        int r122 = 0;
    L32:
        if (r122 >= 5) goto L34;
        r105[r122] = Integer.reverseBytes(r115.readInt());     // Catch: IOException -> L37
        r122 = r122 + 1;     // Catch: IOException -> L37
        goto L32
    L34:
        setBoostResource(1, r101, r113);     // Catch: IOException -> L37
        setBoostResource(3, r103, r113);     // Catch: IOException -> L37
        setBoostResource(5, r105, r113);     // Catch: IOException -> L37
        SPerfUtil.log("Get message : ");     // Catch: IOException -> L37
        SPerfUtil.log("numCpuLevels = " + r107 + ", numGpuLevels = " + r108 + ", numBusLevels = " + r119);     // Catch: IOException -> L37
        SPerfUtil.log("cpus : " + r101[0] + " " + r101[1] + " " + r101[2] + " " + r101[3] + " " + r101[4]);     // Catch: IOException -> L37
        SPerfUtil.log("gpus : " + r103[0] + " " + r103[1] + " " + r103[2] + " " + r103[3] + " " + r103[4]);     // Catch: IOException -> L37
        SPerfUtil.log("buses: " + r105[0] + " " + r105[1] + " " + r105[2] + " " + r105[3] + " " + r105[4]);     // Catch: IOException -> L37
        goto L39
    L24:
        r113 = r109;
        goto L25
    L51:
        return;
    L36:
        return;
    L37:
        e = e;
        goto L38
    }

    public static BoostLevelControl createInstance(SessionControl r100) {
        if (instance != null) goto L10;
        instance = new BoostLevelControl(r100);
        if (isBoostLevelIntialized == true) goto L7;
    L8:
        instance = null;
        goto L10
    L7:
        if (boostResourceCount <= 0) goto L8;
    L10:
        return instance;
    }

    public static BoostResource getBoostResource(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < 11) goto L7;
        return null;
    L7:
        return boostResources[r100];
    }

    public static int getRealBoostLevel(int r100, int r101) {
        if (instance != null) goto L5;
        return -1;
    L5:
        if (r101 >= 0) goto L7;
    L11:
        return -1;
    L7:
        if (r101 >= 11) goto L11;
        return boostResources[r101].getRealBoostLevel(r100);
    }

    public static int getRealBoostLevel(BoostObject r100, int r101) {
        if (instance != null) goto L5;
        return -1;
    L5:
        if (r101 >= 0) goto L7;
    L11:
        return -1;
    L7:
        if (r101 >= 11) goto L11;
        return boostResources[r101].getRealBoostLevel(r100.getLevel(r101));
    }

    private void initScenarioBoostObject() {
        BoostObject r100 = new BoostObject();
        r100.update(0, 2, 64532198);
        r100.update(6, 1, 64532198);
        this.scenarioBoostObjectMap.put(64, r100);
        BoostObject r101 = new BoostObject();
        r101.update(2, 2, 64532198);
        this.scenarioBoostObjectMap.put(128, r101);
        BoostObject r102 = new BoostObject();
        r102.update(4, 2, 64532198);
        this.scenarioBoostObjectMap.put(256, r102);
    }

    public static int setBoostResource(int r100, int[] r101, int r102) {
        if (r100 >= 0) goto L5;
    L12:
        return -1;
    L5:
        if (r100 >= 11) goto L12;
        if (boostResources[r100] == null) goto L10;
        return -1;
    L10:
        SPerfUtil.log("====setBoostResource==== type : " + r100);
        boostResourceCount = boostResourceCount + 1;
        boostResources[r100] = new BoostResource(r101, r102);
        return boostResourceCount;
    }

    public BoostObject getBoostObjectByScenario(int r100, int r101) {
        int r102 = 64;
        BoostObject r103 = null;
    L4:
        if (r102 > 256) goto L16;
        if ((r102 & r100) != r102) goto L15;
        BoostObject r104 = this.scenarioBoostObjectMap.get(Integer.valueOf(r102));
        if (r104 == null) goto L11;
        if (r103 != null) goto L11;
        r103 = new BoostObject();
    L11:
        if (r103 == null) goto L15;
        if (r103.combineBoostObject(r104) == true) goto L15;
        return null;
    L15:
        r102 = r102 << 1;
        goto L4
    L16:
        if (r103 != null) goto L18;
        return null;
    L18:
        int r105 = 0;
    L20:
        if (r105 >= 11) goto L25;
        int r106 = r103.getLevel(r105);
        if (r106 == 64532198) goto L24;
        r103.update(r105, r106, r101);
    L24:
        r105 = r105 + 1;
        goto L20
    L25:
        return r103;
    }

    public int updateBoost(int r100, int r101, int r102, BoostObject r103) {
        if (r100 < 0) goto L21;
        BoostResource[] r104 = boostResources;
        if (r100 >= r104.length) goto L21;
        if (r103 != null) goto L9;
        return -1;
    L9:
        BoostResource r105 = r104[r100];
        if (r105 != null) goto L12;
        return -1;
    L12:
        int r106 = r105.adjustLevel(r101);
        int r107 = boostResources[r100].adjustTimeout(r102);
        if (r106 == r101) goto L17;
        StringBuilder r108 = new StringBuilder("Requested Boost Level is not available : ");
        r108.append(r101);
    L15:
        SPerfUtil.log(r108.toString());
        return -1;
    L17:
        if (r107 == r102) goto L20;
        r108 = new StringBuilder("Requested Boost timeout is not available : ");
        r108.append(r102);
        goto L15
    L20:
        return r103.update(r100, r106, r107);
    L21:
        return -1;
    }
}
