package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ShareScreenConfirm extends Enum<ShareScreenConfirm> implements WireEnum {
    private static final /* synthetic */ ShareScreenConfirm[] $VALUES = null;
    public static final ProtoAdapter<ShareScreenConfirm> ADAPTER = null;
    public static final ShareScreenConfirm ShareScreenConfirm_ALWAYS = null;
    public static final ShareScreenConfirm ShareScreenConfirm_CROSS_TENANT_ONLY = null;
    public static final ShareScreenConfirm ShareScreenConfirm_NONE = null;
    private final int value;

    static {
        ShareScreenConfirm r100 = new ShareScreenConfirm("ShareScreenConfirm_NONE", 0, 0);
        ShareScreenConfirm_NONE = r100;
        ShareScreenConfirm r101 = new ShareScreenConfirm("ShareScreenConfirm_CROSS_TENANT_ONLY", 1, 1);
        ShareScreenConfirm_CROSS_TENANT_ONLY = r101;
        ShareScreenConfirm r102 = new ShareScreenConfirm("ShareScreenConfirm_ALWAYS", 2, 2);
        ShareScreenConfirm_ALWAYS = r102;
        $VALUES = new ShareScreenConfirm[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ShareScreenConfirm.class);
    }

    public static ShareScreenConfirm[] values() {
        return (ShareScreenConfirm[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ShareScreenConfirm fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return ShareScreenConfirm_ALWAYS;
    L12:
        return ShareScreenConfirm_CROSS_TENANT_ONLY;
    L14:
        return ShareScreenConfirm_NONE;
    }

    public static ShareScreenConfirm valueOf(String r100) {
        return (ShareScreenConfirm) a.a(ShareScreenConfirm.class, r100);
    }

    private ShareScreenConfirm(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
