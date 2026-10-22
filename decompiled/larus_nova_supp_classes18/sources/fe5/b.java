package fe5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.tasm.behavior.m;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements m {
    public final /* synthetic */ fe5.a a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ Integer c;

        public a(Context r1, Integer r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r8) {
            Intrinsics.checkNotNullParameter((String) r8, "it");
            Drawable r1 = this.a.getResources().getDrawable(this.b.intValue());
            Integer r9 = this.c;
            if (r9 == null) goto L5;
            Context r0 = this.a;
            int r10 = r9.intValue();
            DrawableCompat.setTint(r1, r0.getResources().getColor(r10));
        L5:
            Intrinsics.checkNotNull(r1);
            return DrawableKt.toBitmap$default(r1, 0, 0, null, 7, null);
        }
    }

    /* JADX INFO: renamed from: fe5.b$b, reason: collision with other inner class name */
    public static final class C0228b<T> implements Consumer {
        public final /* synthetic */ m.a a;

        public C0228b(m.a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            m.a r0 = this.a;
            r0.a((Bitmap) r3, null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ m.a a;

        public c(m.a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            m.a r0 = this.a;
            r0.a(null, (Throwable) r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ m.a a;

        public d(m.a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "loadImage, DOC_SOURCE, loaded bitmap");
            m.a r0 = this.a;
            r0.a((Bitmap) r3, null);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e("ccm-lynx: CCMLynxCardViewImpl", "loadImage, DOC_SOURCE, load icon error:", (Throwable) r4, false);
        }
    }

    public b(fe5.a r1) {
        this.a = r1;
    }

    public final String shouldRedirectImageUrl(String r19) {
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "shouldRedirectImageUrl in imageInterceptor");
        Map<String, Boolean> r0 = ie5.b.a;
        Context r1 = this.a.a;
        InputStream r3 = null;
        if (r19 == null) goto L108;
        Uri r2 = UriProtector.parse(r19);
        String r4 = r2.getScheme();
        String r5 = r2.getHost();
        String r6 = r2.getPath();
        if (TextUtils.isEmpty(r4) == true) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L111;
        int r7 = com.bytedance.ee.bear.doc.resupdate.c.a;
        VFSPath r8 = com.bytedance.ee.bear.doc.resupdate.c.b(eu5.b.a).getVfsPath().subPath(com.bytedance.ee.bear.doc.resupdate.c.a(eu5.b.a, false)).subPath("docs_lynx_channel");
        String r9 = "";
        if (com.suite.lark.component.storage.ext.b.b(r8) == true) goto L93;
    L46:
        String r10 = "";
    L48:
        if (TextUtils.isEmpty(r10) == false) goto L82;
        String r11 = OperationName.OPERATION_OFFLINE_AVAILABLE + File.separatorChar + "docs_lynx_channel" + r19;
        String r12 = "file:///android_asset/" + r11;
        Map<String, Boolean> r13 = ie5.b.a;
        Object r14 = ((LinkedHashMap) r13).get(r19);
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r15) == false) goto L91;
    L59:
        r9 = r12;
    L74:
        r10 = r9;
        goto L82
    L91:
        r3 = eu5.b.a.getAssets().open(r11);     // Catch: Throwable -> L65 Exception -> L67
        if (r3.available() <= 0) goto L89;
        r13.put(r19, r15);     // Catch: Throwable -> L65 Exception -> L67
    L96:
        r3.close();     // Catch: Exception -> L57
    L57:
        e = move-exception;
        tt5.a.e("ccm-lynx: LynxImageUrlUtils", "wrapperAssetUrl close stream", e, false);
        goto L59
    L89:
        r3.close();     // Catch: Exception -> L62
    L64:
        ie5.b.a.put(r19, Boolean.FALSE);
    L62:
        e = move-exception;
        tt5.a.e("ccm-lynx: LynxImageUrlUtils", "wrapperAssetUrl close stream", e, false);
    L67:
        e = move-exception;
        ie5.b.a.put(r19, Boolean.FALSE);     // Catch: Throwable -> L65
        tt5.a.e("ccm-lynx: LynxImageUrlUtils", "wrapperAssetUrl", e, false);     // Catch: Throwable -> L65
        if (r3 == null) goto L74;
        r3.close();     // Catch: Exception -> L72
    L72:
        e = move-exception;
        tt5.a.e("ccm-lynx: LynxImageUrlUtils", "wrapperAssetUrl close stream", e, false);
    L65:
        th = move-exception;
        if (r3 == null) goto L106;
        r3.close();     // Catch: Exception -> L78
        throw th;
    L78:
        e = move-exception;
        tt5.a.e("ccm-lynx: LynxImageUrlUtils", "wrapperAssetUrl close stream", e, false);
        throw th;
    L106:
        throw th;
    L82:
        if (TextUtils.isEmpty(r10) == false) goto L85;
        r10 = ie5.d.a() + r19;
    L85:
        return r10;
    L93:
        Map<String, Long> r16 = ie5.b.b;     // Catch: Exception -> L44
        Object r17 = ((LinkedHashMap) r16).get(r19);     // Catch: Exception -> L44
        Long r18 = (Long) r17;     // Catch: Exception -> L44
        if (r18 == null) goto L20;
        r18.longValue();     // Catch: Exception -> L44
        VFSPath r20 = r8.subPath(((Long) r17).toString()).subPath("res".concat(r19));     // Catch: Exception -> L44
        if (com.suite.lark.component.storage.ext.b.b(r20) == false) goto L19;
        r10 = r20.getRealPath();     // Catch: Exception -> L44
        goto L48
    L19:
        Long r21 = r16.remove(r19);     // Catch: Exception -> L44
    L20:
        File[] r22 = ay4.d.a().listFiles(r8);     // Catch: Exception -> L44
        if (r22.length != 0) goto L23;
        boolean r23 = true;
    L24:
        if (r23 == false) goto L26;
        Long r110 = null;
    L39:
        if (r110 == null) goto L46;
        r110.longValue();     // Catch: Exception -> L44
        VFSPath r24 = r8.subPath(r110.toString()).subPath("res" + r19);     // Catch: Exception -> L44
        if (com.suite.lark.component.storage.ext.b.b(r24) == false) goto L46;
        ie5.b.b.put(r19, r110);     // Catch: Exception -> L44
        r10 = r24.getRealPath();     // Catch: Exception -> L44
        goto L48
    L26:
        int r25 = r22.length;     // Catch: Exception -> L44
        r110 = null;
        int r111 = 0;
    L27:
        if (r111 >= r25) goto L39;
        File r112 = r22[r111];     // Catch: Exception -> L44
        if (r112.isDirectory() == false) goto L38;
        String r113 = r112.getName();     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r113);     // Catch: Exception -> L86
        long r114 = CastLongProtector.parseLong(r113);     // Catch: Exception -> L86
        if (r110 != null) goto L36;
        r110 = Long.valueOf(r114);     // Catch: Exception -> L44
        goto L38
    L36:
        if (r114 <= r110.longValue()) goto L38;
        r110 = Long.valueOf(r114);     // Catch: Exception -> L44
    L38:
        r111 = r111 + 1;     // Catch: Exception -> L44
        goto L27
    L23:
        r23 = false;
    L44:
        e = move-exception;
        tt5.a.e("ccm-lynx: LynxImageUrlUtils", "wrapperGeckoUrl", e, false);
        goto L46
    L111:
        return null;
    L108:
        return null;
    }

    public final void loadImage(Context r5, String r6, String r7, float r8, float r9, Transformer r10, m.a r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r11, "handler");
        Uri r12 = UriProtector.parse(r7);
        String r13 = r12.getScheme();
        String r14 = r12.getHost();
        String r15 = "";
        if (Intrinsics.areEqual("appImage", r13) == false) goto L21;
        if (TextUtils.isEmpty(r14) == true) goto L21;
        if (r14 == null) goto L11;
        Map<String, Pair<Integer, Integer>> r16 = com.bytedance.ee.bear.lynx.impl.d.a;
        Intrinsics.checkNotNullParameter(r14, "drawableKey");
        Pair r17 = (Pair) ((LinkedHashMap) com.bytedance.ee.bear.lynx.impl.d.a).get(r14);
        if (r17 == null) goto L11;
        Integer r18 = (Integer) r17.getFirst();
    L12:
        if (r14 == null) goto L16;
        Map<String, Pair<Integer, Integer>> r19 = com.bytedance.ee.bear.lynx.impl.d.a;
        Intrinsics.checkNotNullParameter(r14, "drawableKey");
        Pair r20 = (Pair) ((LinkedHashMap) com.bytedance.ee.bear.lynx.impl.d.a).get(r14);
        if (r20 == null) goto L16;
        Integer r21 = (Integer) r20.getSecond();
    L17:
        if (r18 == null) goto L19;
        Flowable.just("").subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).map(new a(r5, r18, r21)).subscribe(new C0228b(r11), new c(r11));
        return;
    L19:
        r11.a(null, new IllegalArgumentException("loadImage failed, drawableId is null"));
        return;
    L16:
        r21 = null;
    L11:
        r18 = null;
    L21:
        if (Intrinsics.areEqual("docsource", r13) == false) goto L70;
        fe5.a r22 = this.a;
        Intrinsics.checkNotNull(r12);
        String r23 = fe5.a.i(r22, r12, "iconInfo");
        if (r23 != null) goto L25;
        r23 = "";
    L25:
        boolean r24 = false;
        JSONObject r25 = new JSONObject(r23);     // Catch: Exception -> L28
    L30:
        String r26 = r25.optString(ResourceData.KEY_TOKEN);
        if (r26 != null) goto L33;
        r26 = "";
    L33:
        int r27 = r25.optInt("obj_type", -1);
        String r28 = fe5.a.i(this.a, r12, "shape");
        if (r28 == null) goto L39;
        String r29 = r28.toUpperCase(Locale.ROOT);
        if (r29 == null) goto L39;
        r15 = r29;
    L39:
        int r30 = r15.hashCode();
        if (r30 == (-1841345251)) goto L54;
        if (r30 == (-1177675008)) goto L50;
        if (r30 == 1988079824) goto L47;
    L55:
        IconShape r31 = IconShape.CIRCLE;
    L58:
        if (r26.length() != 0) goto L60;
        boolean r110 = true;
    L61:
        if (r110 == true) goto L69;
        if (r27 == (-1)) goto L69;
        if (r23.length() != 0) goto L66;
        r24 = true;
    L66:
        if (r24 == true) goto L69;
        this.a.g.add(mbb.c.a(r26, r27, r23, r31, null).subscribe(new d(r11), e.a));
        return;
    L69:
        r11.a(null, null);
        return;
    L60:
        r110 = false;
        goto L61
    L47:
        if (r15.equals("CIRCLE") == false) goto L55;
        r31 = IconShape.CIRCLE;
        goto L58
    L50:
        if (r15.equals("SQUARE_OUTLINE") == false) goto L55;
        r31 = IconShape.SQUARE_OUTLINE;
        goto L58
    L54:
        if (r15.equals("SQUARE") == false) goto L55;
        r31 = IconShape.SQUARE;
    L28:
        e = move-exception;
        tt5.a.e("ccm-lynx: CCMLynxCardViewImpl", "loadImage, DOC_SOURCE, convert iconInfo json error:", e, false);
        r25 = new JSONObject();
        goto L30
    L70:
        r11.a(null, null);
    }
}
