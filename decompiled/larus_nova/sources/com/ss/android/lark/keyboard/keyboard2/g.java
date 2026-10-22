package com.ss.android.lark.keyboard.keyboard2;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f429547a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f429548a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<KeyboardMenuItemKey, Integer> f429549b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C5103a f429550c = null;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.keyboard2.g$a$a, reason: collision with other inner class name */
        public static final class C5103a implements g {

            /* JADX INFO: renamed from: com.ss.android.lark.keyboard.keyboard2.g$a$a$a, reason: collision with other inner class name */
            public static final class C5104a<T> implements Comparator {
                public C5104a() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T r100, T r101) {
                    Map<KeyboardMenuItemKey, Integer> r102 = a.f429549b;
                    EnumMap r103 = (EnumMap) r102;
                    EnumMap r104 = (EnumMap) r102;
                    return ComparisonsKt.compareValues((Integer) r103.get(((m) r100).g()), (Integer) r104.get(((m) r101).g()));
                }
            }

            public C5103a() {
            }

            @Override // com.ss.android.lark.keyboard.keyboard2.g
            public final List<m> a(List<? extends m> r100) {
                Intrinsics.checkNotNullParameter(r100, "items");
                return CollectionsKt.sortedWith(r100, new C5104a());
            }
        }

        public a() {
        }

        static {
            f429548a = new a();
            EnumMap r100 = new EnumMap(KeyboardMenuItemKey.class);
            f429549b = r100;
            r100.put(KeyboardMenuItemKey.Emoji, 1);
            r100.put(KeyboardMenuItemKey.At, 2);
            r100.put(KeyboardMenuItemKey.Voice, 3);
            r100.put(KeyboardMenuItemKey.Photo, 4);
            r100.put(KeyboardMenuItemKey.File, 5);
            r100.put(KeyboardMenuItemKey.BurnLife, 6);
            r100.put(KeyboardMenuItemKey.AaStyle, 7);
            r100.put(KeyboardMenuItemKey.RestrictedBurnLife, 8);
            r100.put(KeyboardMenuItemKey.Plus, 9);
            r100.put(KeyboardMenuItemKey.UploadLog, 10);
            f429550c = new C5103a();
        }
    }

    static {
        f429547a = a.f429548a;
    }

    List<m> a(List<? extends m> r100);
}
