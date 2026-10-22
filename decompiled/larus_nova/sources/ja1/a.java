package ja1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.schema.helper.g;
import com.bytedance.android.live.schema.helper.h;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ja1.b> f497833a;

    /* JADX INFO: renamed from: ja1.a$a, reason: collision with other inner class name */
    public static final class C6406a implements ja1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f497834a;

        public C6406a(Bundle r100) {
            this.f497834a = r100;
        }

        @Override // ja1.b
        public final boolean a(String r100) {
            Bundle r101 = this.f497834a;
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ja1.b
        public final <O> O b(String r100, O r101) {
        L43:
            e = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("HybridParsing", e);
            com.bytedance.android.live.schema.api.utils.a.b("HybridParsing", "type is error " + r101, null);
            return r101;
        L4:
            if ((r101 instanceof Integer) == false) goto L22;
            Bundle r102 = this.f497834a;     // Catch: Exception -> L43
            if (r102 == null) goto L8;
            Object r103 = r102.get(r100);     // Catch: Exception -> L43
        L10:
            if ((r103 instanceof Boolean) == true) goto L12;
            Bundle r104 = this.f497834a;     // Catch: Exception -> L43
            if (r104 != null) goto L20;
            return null;
        L20:
            return (O) Integer.valueOf(r104.getInt(r100, ((Number) r101).intValue()));
        L12:
            if (this.f497834a.getBoolean(r100) == false) goto L14;
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
            Bundle r106 = this.f497834a;     // Catch: Exception -> L43
            if (r106 != null) goto L26;
            return null;
        L26:
            return (O) Boolean.valueOf(r106.getBoolean(r100, ((Boolean) r101).booleanValue()));
        L28:
            if ((r101 instanceof String) == false) goto L34;
            Bundle r107 = this.f497834a;     // Catch: Exception -> L43
            if (r107 != null) goto L32;
            return null;
        L32:
            return (O) r107.getString(r100, (String) r101);
        L34:
            if ((r101 instanceof Float) == false) goto L39;
            Bundle r108 = this.f497834a;     // Catch: Exception -> L43
            if (r108 != null) goto L38;
            return null;
        L38:
            return (O) Float.valueOf(r108.getFloat(r100, ((Number) r101).floatValue()));
        L39:
            Bundle r109 = this.f497834a;     // Catch: Exception -> L43
            if (r109 != null) goto L42;
            return null;
        L42:
            return (O) r109.get(r100);
        }
    }

    public static final class b implements ja1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f497835a;

        public b(Uri r100) {
            this.f497835a = h.a(r100);
        }

        @Override // ja1.b
        public final boolean a(String r100) {
            Map<String, String> r101 = this.f497835a;
            if (r101 == null) goto L16;
        L8:
            th = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        L10:
            boolean r102 = false;
        L11:
            if (r102 == false) goto L17;
            return true;
        L17:
            return false;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L10;
            r102 = ((HashMap) r101).containsKey(r100);     // Catch: Throwable -> L8
            goto L11
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ja1.b
        public final <O> O b(String r100, O r101) {
            if ((r101 instanceof Integer) == false) goto L11;
            String r102 = g.a(this.f497835a, r100);
            int r103 = ((Number) r101).intValue();
            if (r102 == null) goto L9;
            r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L30
        L9:
            return (O) Integer.valueOf(r103);
        L11:
            if ((r101 instanceof Boolean) == false) goto L15;
            return (O) d5.a(g.a(this.f497835a, r100), ((Boolean) r101).booleanValue());
        L15:
            if ((r101 instanceof String) == false) goto L19;
            return (O) g.a(this.f497835a, r100);
        L19:
            if ((r101 instanceof Float) == false) goto L25;
            String r104 = g.a(this.f497835a, r100);
            float r105 = ((Number) r101).floatValue();
            r105 = CastFloatProtector.parseFloat(r104);     // Catch: Throwable -> L31
        L23:
            return (O) Float.valueOf(r105);
        L25:
            if ((r101 instanceof Long) == true) goto L27;
            com.bytedance.android.live.schema.api.utils.a.b("HybridParsing", "type is error " + r101, null);
            return r101;
        L27:
            return (O) Long.valueOf(d5.c(g.a(this.f497835a, r100)));
        }
    }

    public static final class c implements ja1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f497836a;

        public c(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L12;
        L9:
            Uri r101 = null;
        L10:
            this.f497836a = h.a(r101);
            return;
        L12:
            r101 = UriProtector.parse(r100);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
            goto L9
        }

        @Override // ja1.b
        public final boolean a(String r100) {
            Map<String, String> r101 = this.f497836a;
            if (r101 == null) goto L16;
        L8:
            th = move-exception;
            com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        L10:
            boolean r102 = false;
        L11:
            if (r102 == false) goto L17;
            return true;
        L17:
            return false;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L10;
            r102 = ((HashMap) r101).containsKey(r100);     // Catch: Throwable -> L8
            goto L11
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ja1.b
        public final <O> O b(String r100, O r101) {
            if ((r101 instanceof Integer) == false) goto L11;
            String r102 = g.a(this.f497836a, r100);
            int r103 = ((Number) r101).intValue();
            if (r102 == null) goto L9;
            r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L20
        L9:
            return (O) Integer.valueOf(r103);
        L11:
            if ((r101 instanceof Boolean) == false) goto L15;
            return (O) d5.a(g.a(this.f497836a, r100), ((Boolean) r101).booleanValue());
        L15:
            if ((r101 instanceof String) == true) goto L17;
            com.bytedance.android.live.schema.api.utils.a.b("HybridParsing", "type is error " + r101, null);
            return r101;
        L17:
            return (O) g.a(this.f497836a, r100);
        }
    }

    public final <O> O a(String r100, O r101) {
        List<ja1.b> r102 = this.f497833a;
        if (r102 != null) goto L5;
    L14:
        return r101;
    L5:
        if (((ArrayList) r102).isEmpty() == true) goto L14;
        Iterator r103 = ((ArrayList) this.f497833a).iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        ja1.b r104 = (ja1.b) r103.next();
        if (r104.a(r100) == false) goto L9;
        return (O) r104.b(r100, r101);
    }

    public a(Uri r100, String r101, Bundle r102) {
        ArrayList r103 = new ArrayList();
        this.f497833a = r103;
        r103.add(new c(r101));
        r103.add(new b(r100));
        r103.add(new C6406a(r102));
    }
}
