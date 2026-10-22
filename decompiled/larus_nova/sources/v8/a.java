package v8;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.annie.scheme.helper.LiveSchemaUtil;
import com.bytedance.android.annie.util.l;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<v8.b> f553587a;

    /* JADX INFO: renamed from: v8.a$a, reason: collision with other inner class name */
    public static final class C7970a implements v8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f553588a;

        public C7970a(Bundle r100) {
            this.f553588a = r100;
        }

        @Override // v8.b
        public final boolean a(String r100) {
            Bundle r101 = this.f553588a;
            if (r101 == null) goto L5;
            Object r102 = r101.get(r100);
        L6:
            if (r102 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r102 = null;
            goto L6
        }

        @Override // v8.b
        public final boolean d(String r100) {
            return a(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O b(String r100, O r101) {
        L43:
            e = move-exception;
            x8.a.c("HybridParsing", e, false);
            x8.a.b("HybridParsing", "type is error " + r101, false);
            return r101;
        L4:
            if ((r101 instanceof Integer) == false) goto L22;
            Bundle r102 = this.f553588a;     // Catch: Exception -> L43
            if (r102 == null) goto L8;
            Object r103 = r102.get(r100);     // Catch: Exception -> L43
        L10:
            if ((r103 instanceof Boolean) == true) goto L12;
            Bundle r104 = this.f553588a;     // Catch: Exception -> L43
            if (r104 != null) goto L20;
            return null;
        L20:
            return (O) Integer.valueOf(r104.getInt(r100, ((Number) r101).intValue()));
        L12:
            if (this.f553588a.getBoolean(r100) == false) goto L14;
            int r105 = 1;
        L16:
            return (O) Integer.valueOf(r105);
        L14:
            r105 = 0;
            goto L16
        L8:
            r103 = null;
            goto L10
        L22:
            if ((r101 instanceof Boolean) == false) goto L28;
            Bundle r106 = this.f553588a;     // Catch: Exception -> L43
            if (r106 != null) goto L26;
            return null;
        L26:
            return (O) Boolean.valueOf(r106.getBoolean(r100, ((Boolean) r101).booleanValue()));
        L28:
            if ((r101 instanceof String) == false) goto L34;
            Bundle r107 = this.f553588a;     // Catch: Exception -> L43
            if (r107 != null) goto L32;
            return null;
        L32:
            return (O) r107.getString(r100, (String) r101);
        L34:
            if ((r101 instanceof Float) == false) goto L39;
            Bundle r108 = this.f553588a;     // Catch: Exception -> L43
            if (r108 != null) goto L38;
            return null;
        L38:
            return (O) Float.valueOf(r108.getFloat(r100, ((Number) r101).floatValue()));
        L39:
            Bundle r109 = this.f553588a;     // Catch: Exception -> L43
            if (r109 != null) goto L42;
            return null;
        L42:
            return (O) r109.get(r100);
        }

        @Override // v8.b
        public final <O> O c(String r100, O r101) {
            return (O) b(r100, r101);
        }
    }

    public static final class b implements v8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f553589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f553590b;

        public b(Uri r100) {
            this.f553589a = r100;
            if (LiveSchemaUtil.a() == false) goto L6;
            this.f553590b = com.bytedance.android.annie.scheme.helper.c.a(r100);
            return;
        }

        @Override // v8.b
        public final boolean a(String r100) {
            Uri r101 = this.f553589a;
            if (r101 != null) goto L16;
            return false;
        L16:
        L11:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L10:
            boolean r102 = false;
        L13:
            if (r102 == false) goto L19;
            return true;
        L19:
            return false;
        L6:
            if (TextUtils.isEmpty(r100) == true) goto L10;
            if (UriProtector.getQueryParameter(r101, r100) == null) goto L10;
            r102 = true;
            goto L13
        }

        @Override // v8.b
        public final boolean d(String r100) {
            Map<String, String> r101 = this.f553590b;
            if (r101 != null) goto L15;
            return false;
        L15:
        L9:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L11:
            boolean r102 = false;
        L12:
            if (r102 == false) goto L18;
            return true;
        L18:
            return false;
        L6:
            if (TextUtils.isEmpty(r100) == true) goto L11;
            r102 = ((HashMap) r101).containsKey(r100);     // Catch: Throwable -> L9
            goto L12
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O b(String r100, O r101) {
            if ((r101 instanceof Integer) == false) goto L11;
            String r102 = com.bytedance.android.annie.scheme.helper.b.a(this.f553589a, r100);
            int r103 = ((Number) r101).intValue();
            if (r102 == null) goto L9;
            r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r103);
        L11:
            if ((r101 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.a(this.f553589a, r100), ((Boolean) r101).booleanValue());
        L15:
            if ((r101 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.a(this.f553589a, r100);
        L19:
            if ((r101 instanceof Float) == false) goto L25;
            String r104 = com.bytedance.android.annie.scheme.helper.b.a(this.f553589a, r100);
            float r105 = ((Number) r101).floatValue();
            r105 = CastFloatProtector.parseFloat(r104);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r105);
        L25:
            if ((r101 instanceof Long) == true) goto L38;
            int r106 = x8.a.f562881a;
            x8.a.b("HybridParsing", "type is error " + r101, false);
            return r101;
        L38:
            long r107 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.a(this.f553589a, r100));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r107);
        L29:
            r107 = 0;
            goto L31
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O c(String r100, O r101) {
            if ((r101 instanceof Integer) == false) goto L11;
            String r102 = com.bytedance.android.annie.scheme.helper.b.b(this.f553590b, r100);
            int r103 = ((Number) r101).intValue();
            if (r102 == null) goto L9;
            r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r103);
        L11:
            if ((r101 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.b(this.f553590b, r100), ((Boolean) r101).booleanValue());
        L15:
            if ((r101 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.b(this.f553590b, r100);
        L19:
            if ((r101 instanceof Float) == false) goto L25;
            String r104 = com.bytedance.android.annie.scheme.helper.b.b(this.f553590b, r100);
            float r105 = ((Number) r101).floatValue();
            r105 = CastFloatProtector.parseFloat(r104);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r105);
        L25:
            if ((r101 instanceof Long) == true) goto L38;
            int r106 = x8.a.f562881a;
            x8.a.b("HybridParsing", "type is error " + r101, false);
            return r101;
        L38:
            long r107 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.b(this.f553590b, r100));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r107);
        L29:
            r107 = 0;
            goto L31
        }
    }

    public static final class c implements v8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f553591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f553592b;

        public c(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L14;
        L9:
            Uri r101 = null;
        L10:
            this.f553591a = r101;
            if (LiveSchemaUtil.a() == false) goto L16;
            this.f553592b = com.bytedance.android.annie.scheme.helper.c.a(r101);
            return;
        L16:
            return;
        L14:
            r101 = UriProtector.parse(r100);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            int r102 = x8.a.f562881a;
            x8.a.c("ParsingUriParamHelper", th, true);
            goto L9
        }

        @Override // v8.b
        public final boolean a(String r100) {
            Uri r101 = this.f553591a;
            if (r101 != null) goto L16;
            return false;
        L16:
        L11:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L10:
            boolean r102 = false;
        L13:
            if (r102 == false) goto L19;
            return true;
        L19:
            return false;
        L6:
            if (TextUtils.isEmpty(r100) == true) goto L10;
            if (UriProtector.getQueryParameter(r101, r100) == null) goto L10;
            r102 = true;
            goto L13
        }

        @Override // v8.b
        public final boolean d(String r100) {
            Map<String, String> r101 = this.f553592b;
            if (r101 != null) goto L15;
            return false;
        L15:
        L9:
            th = move-exception;
            x8.a.c("ParsingUriParamHelper", th, true);
        L11:
            boolean r102 = false;
        L12:
            if (r102 == false) goto L18;
            return true;
        L18:
            return false;
        L6:
            if (TextUtils.isEmpty(r100) == true) goto L11;
            r102 = ((HashMap) r101).containsKey(r100);     // Catch: Throwable -> L9
            goto L12
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O b(String r100, O r101) {
            if ((r101 instanceof Integer) == false) goto L11;
            String r102 = com.bytedance.android.annie.scheme.helper.b.a(this.f553591a, r100);
            int r103 = ((Number) r101).intValue();
            if (r102 == null) goto L9;
            r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r103);
        L11:
            if ((r101 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.a(this.f553591a, r100), ((Boolean) r101).booleanValue());
        L15:
            if ((r101 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.a(this.f553591a, r100);
        L19:
            if ((r101 instanceof Float) == false) goto L25;
            String r104 = com.bytedance.android.annie.scheme.helper.b.a(this.f553591a, r100);
            float r105 = ((Number) r101).floatValue();
            r105 = CastFloatProtector.parseFloat(r104);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r105);
        L25:
            if ((r101 instanceof Long) == true) goto L38;
            int r106 = x8.a.f562881a;
            x8.a.b("HybridParsing", "type is error " + r101, false);
            return r101;
        L38:
            long r107 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.a(this.f553591a, r100));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r107);
        L29:
            r107 = 0;
            goto L31
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // v8.b
        public final <O> O c(String r100, O r101) {
            if ((r101 instanceof Integer) == false) goto L11;
            String r102 = com.bytedance.android.annie.scheme.helper.b.b(this.f553592b, r100);
            int r103 = ((Number) r101).intValue();
            if (r102 == null) goto L9;
            r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L34
        L9:
            return (O) Integer.valueOf(r103);
        L11:
            if ((r101 instanceof Boolean) == false) goto L15;
            return (O) l.a(com.bytedance.android.annie.scheme.helper.b.b(this.f553592b, r100), ((Boolean) r101).booleanValue());
        L15:
            if ((r101 instanceof String) == false) goto L19;
            return (O) com.bytedance.android.annie.scheme.helper.b.b(this.f553592b, r100);
        L19:
            if ((r101 instanceof Float) == false) goto L25;
            String r104 = com.bytedance.android.annie.scheme.helper.b.b(this.f553592b, r100);
            float r105 = ((Number) r101).floatValue();
            r105 = CastFloatProtector.parseFloat(r104);     // Catch: Throwable -> L35
        L23:
            return (O) Float.valueOf(r105);
        L25:
            if ((r101 instanceof Long) == true) goto L38;
            int r106 = x8.a.f562881a;
            x8.a.b("HybridParsing", "type is error " + r101, false);
            return r101;
        L38:
            long r107 = CastLongProtector.parseLong(com.bytedance.android.annie.scheme.helper.b.b(this.f553592b, r100));     // Catch: Throwable -> L29
        L31:
            return (O) Long.valueOf(r107);
        L29:
            r107 = 0;
            goto L31
        }
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L6;
        return r100;
    L6:
        if (new Regex("^([a-fA-F\\d]{8}|[a-fA-F\\d]{6}|[a-fA-F\\d]{3})$").matches(r100) == true) goto L8;
        return r100;
    L8:
        return "#" + r100;
    }

    public final <O> O b(String r100, O r101) {
        List<v8.b> r102 = this.f553587a;
        if (r102 != null) goto L5;
    L23:
        return r101;
    L5:
        if (((ArrayList) r102).isEmpty() == true) goto L23;
        if (LiveSchemaUtil.a() == false) goto L16;
        Iterator r103 = ((ArrayList) this.f553587a).iterator();
    L11:
        if (r103.hasNext() == false) goto L23;
        v8.b r104 = (v8.b) r103.next();
        if (r104.d(r100) == false) goto L11;
        return (O) r104.c(r100, r101);
    L16:
        Iterator r105 = ((ArrayList) this.f553587a).iterator();
    L18:
        if (r105.hasNext() == false) goto L23;
        v8.b r106 = (v8.b) r105.next();
        if (r106.a(r100) == false) goto L18;
        return (O) r106.b(r100, r101);
    }

    public a(Uri r100, String r101, Bundle r102) {
        ArrayList r103 = new ArrayList();
        this.f553587a = r103;
        r103.add(new c(r101));
        r103.add(new b(r100));
        r103.add(new C7970a(r102));
    }
}
