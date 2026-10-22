package com.ss.android.lark.officesdk.api.init;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "", "isEnabled", "", "biz", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider$Biz;", "isLaunchEnabled", "Biz", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSDKBizConfigProvider {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider$Biz;", "", "<init>", "(Ljava/lang/String;I)V", "IM", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Biz extends Enum<Biz> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Biz[] $VALUES = null;
        public static final Biz IM = null;

        private static final /* synthetic */ Biz[] $values() {
            return new Biz[]{IM};
        }

        public static EnumEntries<Biz> getEntries() {
            return $ENTRIES;
        }

        static {
            IM = new Biz("IM", 0);
            Biz[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Biz[] values() {
            return (Biz[]) $VALUES.clone();
        }

        public static Biz valueOf(String r100) {
            return (Biz) a.a(Biz.class, r100);
        }

        private Biz(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean isEnabled(Biz r100);

    boolean isLaunchEnabled(Biz r100);
}
