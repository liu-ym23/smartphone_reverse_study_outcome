package com.bytedance.ug.sdk.luckycat.impl.bigredpacket.model;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/bigredpacket/model/RedPacketModelDataSource;", "", HTTP.SERVER, AccountType.LOCAL, "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final enum RedPacketModelDataSource extends Enum<RedPacketModelDataSource> {
    public static final RedPacketModelDataSource LOCAL = null;
    public static final RedPacketModelDataSource SERVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedPacketModelDataSource[] f271071a = null;

    static {
        RedPacketModelDataSource r100 = new RedPacketModelDataSource(HTTP.SERVER, 0);
        SERVER = r100;
        RedPacketModelDataSource r101 = new RedPacketModelDataSource(AccountType.LOCAL, 1);
        LOCAL = r101;
        f271071a = new RedPacketModelDataSource[]{r100, r101};
    }

    public static RedPacketModelDataSource valueOf(String r100) {
        return (RedPacketModelDataSource) a.a(RedPacketModelDataSource.class, r100);
    }

    public static RedPacketModelDataSource[] values() {
        return (RedPacketModelDataSource[]) f271071a.clone();
    }

    public RedPacketModelDataSource(String r100, int r101) {
        super(r100, r101);
    }
}
