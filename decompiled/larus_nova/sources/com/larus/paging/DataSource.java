package com.larus.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class DataSource<Key, Value> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/paging/DataSource$KeyType;", "", "POSITIONAL", "PAGE_KEYED", "ITEM_KEYED", "paging-common_release"}, k = 1, mv = {1, 7, 1})
    public static final enum KeyType extends Enum<KeyType> {
        public static final KeyType ITEM_KEYED = null;
        public static final KeyType PAGE_KEYED = null;
        public static final KeyType POSITIONAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeyType[] f363645a = null;

        public static KeyType valueOf(String r100) {
            return (KeyType) r27.a.a(KeyType.class, r100);
        }

        public static KeyType[] values() {
            return (KeyType[]) f363645a.clone();
        }

        static {
            KeyType r100 = new KeyType("POSITIONAL", 0);
            POSITIONAL = r100;
            KeyType r101 = new KeyType("PAGE_KEYED", 1);
            PAGE_KEYED = r101;
            KeyType r102 = new KeyType("ITEM_KEYED", 2);
            ITEM_KEYED = r102;
            f363645a = new KeyType[]{r100, r101, r102};
        }

        public KeyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f363646a = 0;

        /* JADX INFO: renamed from: com.larus.paging.DataSource$a$a, reason: collision with other inner class name */
        public static final class C4451a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == false) goto L13;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == false) goto L14;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == false) goto L15;
            r101.getClass();
            r101.getClass();
            return true;
        L15:
            return false;
        L14:
            return false;
        L13:
            return false;
        L12:
            return false;
        }
    }

    public static final class b {
    }

    public static abstract class c<Key, Value> {
    }

    public interface d {
        void onInvalidated();
    }

    public static final class e<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f363647a;

        public e(LoadType r100, K r101, int r102, boolean r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f363647a = r101;
            if (r100 == LoadType.REFRESH) goto L8;
            if (r101 == null) goto L7;
            return;
        L7:
            throw new IllegalArgumentException("Key must be non-null for prepend/append");
        }
    }

    static {
    }

    public abstract boolean a();
}
