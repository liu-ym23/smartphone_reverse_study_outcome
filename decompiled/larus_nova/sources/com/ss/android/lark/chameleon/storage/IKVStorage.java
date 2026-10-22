package com.ss.android.lark.chameleon.storage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/storage/IKVStorage;", "", "getBoolean", "", "key", "", "defaultValue", "getString", "put", "", "value", "putBoolean", "putString", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IKVStorage {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void put(IKVStorage r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "value");
            if ((r102 instanceof String) == false) goto L6;
            r100.putString(r101, (String) r102);
            return;
        L6:
            if ((r102 instanceof Boolean) == false) goto L10;
            r100.putBoolean(r101, ((Boolean) r102).booleanValue());
            return;
        }

        public static /* synthetic */ boolean getBoolean$default(IKVStorage r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = false;
        L7:
            return r100.getBoolean(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
        }

        public static /* synthetic */ String getString$default(IKVStorage r100, String r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = "";
        L7:
            return r100.getString(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
        }
    }

    boolean getBoolean(String r100, boolean r101);

    String getString(String r100, String r101);

    void put(String r100, Object r101);

    void putBoolean(String r100, boolean r101);

    void putString(String r100, String r101);
}
