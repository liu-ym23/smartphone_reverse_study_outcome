package us9;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.search.impl.combine.model.AutoSearchType;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;
import ws9.c;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AutoSearchType f551547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<e> f551548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<c> f551549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Message> f551550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, e> f551551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, BotModel> f551552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f551553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f551554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f551555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f551556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f551557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f551558m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f551546a, r101.f551546a) == true) goto L12;
        return false;
    L12:
        if (this.f551547b == r101.f551547b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f551548c, r101.f551548c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f551549d, r101.f551549d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f551550e, r101.f551550e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f551551f, r101.f551551f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f551552g, r101.f551552g) == true) goto L30;
        return false;
    L30:
        if (this.f551553h == r101.f551553h) goto L33;
        return false;
    L33:
        if (this.f551554i == r101.f551554i) goto L36;
        return false;
    L36:
        if (this.f551555j == r101.f551555j) goto L39;
        return false;
    L39:
        if (this.f551556k == r101.f551556k) goto L42;
        return false;
    L42:
        if (this.f551557l == r101.f551557l) goto L45;
        return false;
    L45:
        if (this.f551558m == r101.f551558m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f551546a.hashCode() * 31) + this.f551547b.hashCode()) * 31) + this.f551548c.hashCode()) * 31) + this.f551549d.hashCode()) * 31) + this.f551550e.hashCode()) * 31) + this.f551551f.hashCode()) * 31) + this.f551552g.hashCode()) * 31;
        long r101 = this.f551553h;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f551554i;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f551555j;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        int r107 = 1231;
        if (this.f551556k == false) goto L5;
        int r108 = 1231;
    L6:
        int r109 = (r106 + r108) * 31;
        if (this.f551557l == false) goto L9;
        int r110 = 1231;
    L10:
        int r111 = (r109 + r110) * 31;
        if (this.f551558m == true) goto L15;
        r107 = 1237;
    L15:
        return r111 + r107;
    L9:
        r110 = 1237;
        goto L10
    L5:
        r108 = 1237;
        goto L6
    }

    public final String toString() {
        return "SearchResultSnapshot(keyword=" + this.f551546a + ", searchType=" + this.f551547b + ", conversationResultList=" + this.f551548c + ", botResultList=" + this.f551549d + ", messageResultList=" + this.f551550e + ", conversationMap=" + this.f551551f + ", botModelMap=" + this.f551552g + ", currentCursorConversation=" + this.f551553h + ", currentCursorMessage=" + this.f551554i + ", currentCursorBot=" + this.f551555j + ", hasMoreConversation=" + this.f551556k + ", hasMoreMessage=" + this.f551557l + ", hasMoreBots=" + this.f551558m + ')';
    }

    public a(String r110, AutoSearchType r111, ArrayList<e> r112, ArrayList<c> r113, ArrayList<Message> r114, HashMap<String, e> r115, HashMap<String, BotModel> r116, long r117, long r118, long r210, boolean r211, boolean r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, "keyword");
        Intrinsics.checkNotNullParameter(r111, "searchType");
        Intrinsics.checkNotNullParameter(r112, "conversationResultList");
        Intrinsics.checkNotNullParameter(r113, "botResultList");
        Intrinsics.checkNotNullParameter(r114, "messageResultList");
        Intrinsics.checkNotNullParameter(r115, "conversationMap");
        Intrinsics.checkNotNullParameter(r116, "botModelMap");
        this.f551546a = r110;
        this.f551547b = r111;
        this.f551548c = r112;
        this.f551549d = r113;
        this.f551550e = r114;
        this.f551551f = r115;
        this.f551552g = r116;
        this.f551553h = r117;
        this.f551554i = r118;
        this.f551555j = r210;
        this.f551556k = r211;
        this.f551557l = r212;
        this.f551558m = r213;
    }
}
