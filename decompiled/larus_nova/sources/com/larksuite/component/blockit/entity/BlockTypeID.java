package com.larksuite.component.blockit.entity;

import com.larksuite.component.blockit.d;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes24.dex */
public final enum BlockTypeID extends Enum<BlockTypeID> {
    public static final BlockTypeID CALENDAR = null;
    public static final BlockTypeID CCM = null;
    public static final BlockTypeID CHAT = null;
    public static final BlockTypeID EVENT = null;
    public static final BlockTypeID MESSAGE = null;
    public static final BlockTypeID TODO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlockTypeID[] f282979a = null;
    private String onlineValue;
    private String stagingValue;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f282980a = null;

        static {
            int[] r100 = new int[BlockitEnv.values().length];
            f282980a = r100;
            r100[BlockitEnv.STAGING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f282980a[BlockitEnv.PRE_RELEASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f282980a[BlockitEnv.ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        BlockTypeID r100 = new BlockTypeID("CHAT", 0, "blk_5f8f7ccdc2934001f9098d7e", "blk_5f9911efc34e8004f8d44a05");
        CHAT = r100;
        BlockTypeID r101 = new BlockTypeID("MESSAGE", 1, "blk_5f8f7ccdc2934001f9098a49", "blk_5f9911efc34e8004f8d44a06");
        MESSAGE = r101;
        BlockTypeID r102 = new BlockTypeID(AlarmSessionType.EVENT, 2, "blk_604f3523070000133c9aca12", "blk_5f9911a7151940042e838a05");
        EVENT = r102;
        BlockTypeID r103 = new BlockTypeID("CALENDAR", 3, "blk_5f8f7ccba955c00192cf0cf3", "");
        CALENDAR = r103;
        BlockTypeID r104 = new BlockTypeID("CCM", 4, "blk_60506a33c3800013f81aca12", "blk_5f9911cb7bd60001404cca03");
        CCM = r104;
        BlockTypeID r105 = new BlockTypeID(AlarmSessionType.TODO, 5, "blk_6050b23eebc00014d05aca15", "blk_5fe05d609999c003a2030a02");
        TODO = r105;
        f282979a = new BlockTypeID[]{r100, r101, r102, r103, r104, r105};
    }

    public static BlockTypeID[] values() {
        return (BlockTypeID[]) f282979a.clone();
    }

    public String getValue() {
        int r100 = a.f282980a[((d) ApiUtils.getApi(d.class)).getEnv().ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L11;
        return this.stagingValue;
    L11:
        return this.onlineValue;
    L13:
        return this.stagingValue;
    }

    public static BlockTypeID valueOf(String r100) {
        return (BlockTypeID) r27.a.a(BlockTypeID.class, r100);
    }

    public BlockTypeID(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.stagingValue = r102;
        this.onlineValue = r103;
    }
}
