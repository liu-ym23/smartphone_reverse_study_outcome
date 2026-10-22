package com.ss.android.token;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class TokenObjectProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f449700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UriMatcher f449701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f449702c;

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    public TokenObjectProvider() {
        this.f449702c = false;
    }

    public static String a(Context r100) {
        if (r100 != null) goto L16;
        return null;
    L16:
        ProviderInfo r101 = r100.getPackageManager().getProviderInfo(new ComponentName(r100.getPackageName(), TokenObjectProvider.class.getName()), 128);     // Catch: Exception -> L12
        if (r101 == null) goto L14;
        String r102 = r101.authority;     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r102) == true) goto L14;
        tb7.a.a("TokenObjectProvider", "set authority at getting ProviderInfo");     // Catch: Exception -> L12
        return r102;
    L14:
        tb7.a.a("TokenObjectProvider", "set authority at making");
        return r100.getPackageName() + ".TokenObjectProvider";
    L12:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L14
    }

    public final boolean b(Context r100) {
        if (this.f449702c == false) goto L6;
        return true;
    L6:
        if (p.f449778b == true) goto L8;
        return false;
    L8:
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L10:
        if (this.f449702c == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L24
        return true;
    L14:
        if (TextUtils.isEmpty(this.f449700a) == false) goto L17;
        this.f449700a = a(r100);     // Catch: Throwable -> L24
    L17:
        if (TextUtils.isEmpty(this.f449700a) == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L24
        return false;
    L20:
        tb7.a.a("TokenObjectProvider", "authority=" + this.f449700a);     // Catch: Throwable -> L24
        UriMatcher r101 = new UriMatcher(-1);     // Catch: Throwable -> L24
        this.f449701b = r101;     // Catch: Throwable -> L24
        r101.addURI(this.f449700a, "get_token_object", 1);     // Catch: Throwable -> L24
        this.f449701b.addURI(this.f449700a, "set_token_object", 2);     // Catch: Throwable -> L24
        this.f449701b.addURI(this.f449700a, "save_last_token", 3);     // Catch: Throwable -> L24
        this.f449701b.addURI(this.f449700a, "get_last_same_user_token", 4);     // Catch: Throwable -> L24
        this.f449701b.addURI(this.f449700a, "clear_last_token", 5);     // Catch: Throwable -> L24
        this.f449702c = true;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return this.f449702c;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        b(getContext());
        return "vnd.android.cursor.item/vnd." + this.f449700a + ".item";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        if (r101 == null) goto L4;
        tb7.a.a("TokenObjectProvider", "set authority at attachInfo");
        this.f449700a = r101.authority;
    L4:
        super.attachInfo(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        b(getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        b(getContext());
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r210, ContentValues r211, String r212, String[] r213) {
        if (b(getContext()) == true) goto L5;
        return 0;
    L5:
        int r100 = this.f449701b.match(r210);
        tb7.a.a("TokenObjectProvider", "update, code=" + r100);
        if (r100 != 2) goto L37;
        TokenFactory r101 = TokenFactory.j();
        if (r101 == null) goto L65;
        e0 r102 = r101.o();
        if (r210 == null) goto L34;
        String r103 = UriProtector.getQueryParameter(r210, "token");
        String r104 = UriProtector.getQueryParameter(r210, "ts_sign");
        String r105 = UriProtector.getQueryParameter(r210, "attest_ts_sign");
        String r110 = UriProtector.getQueryParameter(r210, "token_encrypted");
        String r111 = UriProtector.getQueryParameter(r210, "token_hash");
        String r112 = UriProtector.getQueryParameter(r210, "track_data");
        String r113 = UriProtector.getQueryParameter(r210, "token_tlb_tag");
        String r106 = UriProtector.getQueryParameter(r210, "is_login");
        if (TextUtils.isEmpty(r106) == false) goto L68;
    L17:
        int r214 = -1;
    L19:
        if (r112 != null) goto L21;
        r112 = "";
    L21:
        TicketTrackData.Serialized r114 = new TicketTrackData.Serialized(r112);
        if (r103 != null) goto L24;
        r103 = "";
    L24:
        if (r104 != null) goto L26;
        String r115 = "";
    L27:
        if (r105 != null) goto L29;
        String r116 = "";
    L30:
        if (r113 != null) goto L32;
        String r117 = "";
    L33:
        e0 r107 = new e0(r103, r115, r116, r114, r117, r214);
        r107.f449730f = r110;
        r107.f449729e = r111;
    L35:
        r101.C("content_provider", r107, null);
        TTTokenMonitor.b("sub_thread", r102.f449725a);
        goto L65
    L32:
        r117 = r113;
        goto L33
    L29:
        r116 = r105;
        goto L30
    L26:
        r115 = r104;
        goto L27
    L68:
        r214 = CastIntegerProtector.parseInt(r106);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        tb7.a.c("TokenObject", "parseFromUri(), parse isLogin fail", th);
        goto L17
    L34:
        r107 = new e0();
    L65:
        return 0;
    L37:
        if (r100 != 3) goto L42;
        TokenFactory r108 = TokenFactory.j();
        if (r108 == null) goto L65;
        r108.z(null);
        goto L65
    L42:
        if (r100 != 5) goto L65;
        TokenFactory r109 = TokenFactory.j();
        if (r109 == null) goto L65;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.f269394r == false) goto L65;
        r109.t(true, "clearLastToken");
        r109.f449664d.getClass();
        tb7.a.a("TokenFactory", "clear last token");
        if (r.f449788b == false) goto L61;
        Object r118 = r.f449798l;
        monitor-enter(r118);
        r.f449793g = "";     // Catch: Throwable -> L58
        AuthTokenMultiProcessSharedProvider.b r119 = r.f449787a;     // Catch: Throwable -> L58
        if (r119 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L58
    L55:
        AuthTokenMultiProcessSharedProvider.a r120 = r119.b();     // Catch: Throwable -> L58
        r120.c("x-tt-token-last", "");     // Catch: Throwable -> L58
        r120.a();     // Catch: Throwable -> L58
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r118);
    L58:
        th = move-exception;
        throw th;
    L61:
        f0 r122 = r.f449790d;
        if (r122 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("tokenObjectProviderHelper");
    L64:
        r122.a();
        goto L65
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r110, String r111, String[] r112, String r113) {
        if (b(getContext()) == true) goto L5;
        return null;
    L5:
        int r101 = this.f449701b.match(r100);
        tb7.a.a("TokenObjectProvider", "query, code=" + r101);
        if (r101 != 1) goto L16;
        TokenFactory r102 = TokenFactory.j();
        if (r102 == null) goto L24;
        e0 r103 = r102.o();
        r103.getClass();
        MatrixCursor r114 = new MatrixCursor(new String[]{"token", "ts_sign", "attest_ts_sign", "token_encrypted", "token_hash", "track_data", "token_tlb_tag", "is_login"});
        MatrixCursor.RowBuilder r115 = r114.newRow().add(r103.f449725a).add(r103.f449726b).add(r103.f449727c).add(r103.f449730f).add(r103.f449729e);
        com.bytedance.sdk.account.utils.j<TicketTrackData> r116 = r103.f449728d;
        if (r116 != null) goto L12;
        String r117 = "";
    L13:
        r115.add(r117).add(r103.f449731g).add(Integer.valueOf(r103.f449732h));
        return r114;
    L12:
        r117 = r116.a();
    L24:
        return null;
    L16:
        if (r101 != 4) goto L24;
        TokenFactory r104 = TokenFactory.j();
        if (r104 == null) goto L24;
        String r105 = r104.k();
        MatrixCursor r118 = new MatrixCursor(new String[]{"last_token"});     // Catch: Exception -> L22
        r118.newRow().add(r105);     // Catch: Exception -> L22
        return r118;
    L22:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L24
    }
}
