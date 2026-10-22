package com.larus.livetutor.impl.typing.datasource;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/livetutor/impl/typing/datasource/DataSourceUpdateMode;", "", "<init>", "(Ljava/lang/String;I)V", "Create", UserChangedCallback.CHANGE_TYPE_UPDATE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataSourceUpdateMode extends Enum<DataSourceUpdateMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DataSourceUpdateMode[] $VALUES = null;
    public static final DataSourceUpdateMode Create = null;
    public static final DataSourceUpdateMode Update = null;

    private static final /* synthetic */ DataSourceUpdateMode[] $values() {
        return new DataSourceUpdateMode[]{Create, Update};
    }

    public static EnumEntries<DataSourceUpdateMode> getEntries() {
        return $ENTRIES;
    }

    static {
        Create = new DataSourceUpdateMode("Create", 0);
        Update = new DataSourceUpdateMode(UserChangedCallback.CHANGE_TYPE_UPDATE, 1);
        DataSourceUpdateMode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DataSourceUpdateMode[] values() {
        return (DataSourceUpdateMode[]) $VALUES.clone();
    }

    public static DataSourceUpdateMode valueOf(String r100) {
        return (DataSourceUpdateMode) r27.a.a(DataSourceUpdateMode.class, r100);
    }

    private DataSourceUpdateMode(String r100, int r101) {
        super(r100, r101);
    }
}
