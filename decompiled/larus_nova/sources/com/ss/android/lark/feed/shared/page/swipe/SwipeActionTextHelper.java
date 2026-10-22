package com.ss.android.lark.feed.shared.page.swipe;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class SwipeActionTextHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f421451c = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f421452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<a> f421453b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/swipe/SwipeActionTextHelper$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "START_WIDTH_14", "START_WIDTH_12", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode START_WIDTH_12 = null;
        public static final Mode START_WIDTH_14 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f421454a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421455b = null;

        public static EnumEntries<Mode> getEntries() {
            return f421455b;
        }

        static {
            Mode r100 = new Mode("START_WIDTH_14", 0);
            START_WIDTH_14 = r100;
            Mode r101 = new Mode("START_WIDTH_12", 1);
            START_WIDTH_12 = r101;
            Mode[] r102 = {r100, r101};
            f421454a = r102;
            f421455b = EnumEntriesKt.enumEntries(r102);
        }

        public static Mode[] values() {
            return (Mode[]) f421454a.clone();
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public static final class b {
    }

    static {
        zz7.b.j(14);
        f421451c = zz7.b.j(12);
        zz7.b.j(10);
    }

    public SwipeActionTextHelper() {
        this.f421452a = CollectionsKt.arrayListOf(new a[]{new e(), new f(), new g(), new h(), new i()});
        this.f421453b = CollectionsKt.arrayListOf(new a[]{new com.ss.android.lark.feed.shared.page.swipe.a(), new com.ss.android.lark.feed.shared.page.swipe.b(), new c(), new d()});
    }
}
