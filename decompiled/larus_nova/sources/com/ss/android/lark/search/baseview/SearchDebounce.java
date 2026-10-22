package com.ss.android.lark.search.baseview;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.setting.SearchArgsSetting;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SearchDebounce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f439884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f439885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f439886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f439887d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/search/baseview/SearchDebounce$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Input", "QaInSearch", "search-baseview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type Input = null;
        public static final Type QaInSearch = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f439889a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f439890b = null;

        public static EnumEntries<Type> getEntries() {
            return f439890b;
        }

        static {
            Type r100 = new Type("Input", 0);
            Input = r100;
            Type r101 = new Type("QaInSearch", 1);
            QaInSearch = r101;
            Type[] r102 = {r100, r101};
            f439889a = r102;
            f439890b = EnumEntriesKt.enumEntries(r102);
        }

        public static Type[] values() {
            return (Type[]) f439889a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchDebounce f439891a;

        public a(SearchDebounce r100) {
            this.f439891a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            if (r100.what != 1) goto L7;
            Log.d("LarkSearch.Common.SearchDebounce", "handle DEBOUNCE_SEARCH_MESSAGE_CODE.");
            Runnable r101 = this.f439891a.f439887d;
            if (r101 == null) goto L9;
            r101.run();
            return true;
        L9:
            return true;
        L7:
            return false;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f439892a = null;

        static {
            int[] r100 = new int[Type.values().length];
            r100[Type.Input.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Type.QaInSearch.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f439892a = r100;
        }
    }

    static {
    }

    public final Type getType() {
        return this.f439884a;
    }

    public SearchDebounce(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f439884a = r100;
        int r101 = c.f439892a[r100.ordinal()];
        if (r101 != 1) goto L5;
        long r102 = 200;
    L10:
        this.f439886c = r102;
        SettingManager.getInstance().get(SearchArgsSetting.class, new AnonymousClass1(this));
        this.f439885b = new Handler(Looper.getMainLooper(), new a(this));
        return;
    L5:
        if (r101 != 2) goto L8;
        r102 = 100;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
