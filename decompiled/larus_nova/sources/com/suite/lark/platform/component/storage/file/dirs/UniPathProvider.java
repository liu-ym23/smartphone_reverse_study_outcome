package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public interface UniPathProvider {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/suite/lark/platform/component/storage/file/dirs/UniPathProvider$SpaceType;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LARK, FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SpaceType extends Enum<SpaceType> {
        public static final SpaceType LARK = null;
        public static final SpaceType USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SpaceType[] f460636a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f460637b = null;

        public static EnumEntries<SpaceType> getEntries() {
            return f460637b;
        }

        static {
            SpaceType r100 = new SpaceType(AccountType.LARK, 0);
            LARK = r100;
            SpaceType r101 = new SpaceType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1);
            USER = r101;
            SpaceType[] r102 = {r100, r101};
            f460636a = r102;
            f460637b = EnumEntriesKt.enumEntries(r102);
        }

        public static SpaceType[] values() {
            return (SpaceType[]) f460636a.clone();
        }

        public static SpaceType valueOf(String r100) {
            return (SpaceType) r27.a.a(SpaceType.class, r100);
        }

        public SpaceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static FileStorage a(UniPathProvider r100) {
            SpaceType r101 = r100.c();
            int r102 = b.f460638a[r101.ordinal()];
            if (r102 == 1) goto L10;
            if (r102 != 2) goto L8;
            return LarkFileStorage.c();
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return LarkFileStorage.b();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f460638a = null;

        static {
            int[] r100 = new int[SpaceType.values().length];
            r100[SpaceType.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SpaceType.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f460638a = r100;
        }
    }

    String a(Context r100);

    FileStorage b();

    SpaceType c();

    VFSPath d(FileStorage r100);
}
