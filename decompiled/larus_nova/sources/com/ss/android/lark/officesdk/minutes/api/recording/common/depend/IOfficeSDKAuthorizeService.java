package com.ss.android.lark.officesdk.minutes.api.recording.common.depend;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface IOfficeSDKAuthorizeService extends IOfficeSDKProtocol {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/IOfficeSDKAuthorizeService$Scope;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "USER_LOCATION", "USER_FUZZY_LOCATION", "USER_LOCATION_BACKGROUND", "RECORD", "BLUETOOTH", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scope extends Enum<Scope> {
        public static final Scope BLUETOOTH = null;
        public static final a Companion = null;
        public static final Scope RECORD = null;
        public static final Scope USER_FUZZY_LOCATION = null;
        public static final Scope USER_LOCATION = null;
        public static final Scope USER_LOCATION_BACKGROUND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set<String> f433537a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f433538b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f433539c = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Scope> getEntries() {
            return f433539c;
        }

        static {
            Scope r100 = new Scope("USER_LOCATION", 0, "scope.userLocation");
            USER_LOCATION = r100;
            Scope r101 = new Scope("USER_FUZZY_LOCATION", 1, "scope.userFuzzyLocation");
            USER_FUZZY_LOCATION = r101;
            Scope r102 = new Scope("USER_LOCATION_BACKGROUND", 2, "scope.userLocationBackground");
            USER_LOCATION_BACKGROUND = r102;
            Scope r103 = new Scope("RECORD", 3, "scope.record");
            RECORD = r103;
            Scope r104 = new Scope("BLUETOOTH", 4, "scope.bluetooth");
            BLUETOOTH = r104;
            Scope[] r105 = {r100, r101, r102, r103, r104};
            f433538b = r105;
            f433539c = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
            EnumEntries<Scope> r106 = getEntries();
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
            Iterator<Scope> r108 = r106.iterator();
        L4:
            if (r108.hasNext() == false) goto L6;
            r107.add(r108.next().value);
            goto L4
        L6:
            f433537a = CollectionsKt.toSet(r107);
        }

        public static Scope[] values() {
            return (Scope[]) f433538b.clone();
        }

        public static final /* synthetic */ Set access$getVALUES$cp() {
            return f433537a;
        }

        public final String getValue() {
            return this.value;
        }

        public static Scope valueOf(String r100) {
            return (Scope) r27.a.a(Scope.class, r100);
        }

        public Scope(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f433540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f433541b;

        public /* synthetic */ a() {
            this(true, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f433540a == r101.f433540a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f433541b, r101.f433541b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f433540a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f433541b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "AuthorizeResult(success=" + this.f433540a + ", reason=" + this.f433541b + ')';
        }

        public a(boolean r100, String r101) {
            this.f433540a = r100;
            this.f433541b = r101;
        }
    }

    boolean Q0();

    Object S1(Scope r100, Continuation<? super Boolean> r101);

    Object c1(Scope r100, Continuation<? super a> r101);

    Object e0(FragmentActivity r100, Continuation r101);
}
