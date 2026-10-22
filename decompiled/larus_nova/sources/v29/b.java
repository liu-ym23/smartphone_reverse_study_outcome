package v29;

import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f552731a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f552732a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f552732a, ((a) r100).f552732a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f552732a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "OptionalValue(value=" + this.f552732a + ')';
        }

        public a(String r100) {
            this.f552732a = r100;
        }
    }

    static {
        f552731a = SetsKt.setOf(new String[]{"conversation_id", MusicAppletPage.KEY_MESSAGE_ID, "bot_id", "enter_from"});
    }

    public static Uri a(ContextWindowEntryRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (b(r100.f330235a) == true) goto L5;
        return null;
    L5:
        String r101 = r100.f330236b;
        boolean r102 = false;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        return null;
    L14:
        String r104 = r100.f330237c;
        if (r104 != null) goto L17;
    L18:
        r102 = true;
    L19:
        if (r102 == true) goto L22;
        return null;
    L22:
        if (r100.f330238d.getWireValue().length() <= 32) goto L24;
        return null;
    L24:
        Uri.Builder r105 = new Uri.Builder().scheme(AppConstants.SCHEME_SS_LOCAL).authority(BytedCertConstant.CertKey.FLOW).path("/context_window_usage").appendQueryParameter("conversation_id", r100.f330235a);
        String r106 = r100.f330236b;
        if (r106 == null) goto L27;
        r105.appendQueryParameter(MusicAppletPage.KEY_MESSAGE_ID, r106);
    L27:
        String r107 = r100.f330237c;
        if (r107 == null) goto L31;
        r105.appendQueryParameter("bot_id", r107);
    L31:
        return r105.appendQueryParameter("enter_from", r100.f330238d.getWireValue()).build();
    L17:
        if (b(r104) == false) goto L19;
    L8:
        if (b(r101) == true) goto L11;
        r103 = false;
        goto L12
    }

    public static boolean b(String r100) {
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.length() > 128) goto L7;
        return true;
    }

    public static ContextWindowEntryRequest d(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        if (r110.isHierarchical() == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r110.getScheme(), AppConstants.SCHEME_SS_LOCAL) == true) goto L8;
    L80:
        return null;
    L8:
        if (Intrinsics.areEqual(r110.getHost(), BytedCertConstant.CertKey.FLOW) == false) goto L80;
        if (Intrinsics.areEqual(r110.getPath(), "/context_window_usage") == false) goto L80;
        if (r110.getUserInfo() != null) goto L80;
        if (r110.getPort() != (-1)) goto L80;
        if (r110.getFragment() != null) goto L80;
        Set<String> r100 = UriProtector.getQueryParameterNames(r110);
        Set<String> r101 = f552731a;
        Intrinsics.checkNotNull(r100);
        if (r101.containsAll(r100) == true) goto L22;
        return null;
    L22:
        Set<String> r102 = r100;
        boolean r103 = true;
        int r104 = 0;
        if ((r102 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r105 = r102.iterator();
    L29:
        if (r105.hasNext() == false) goto L36;
        if (UriProtector.getQueryParameters(r110, (String) r105.next()).size() == 1) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L29;
        boolean r107 = true;
    L37:
        if (r107 == false) goto L39;
        return null;
    L39:
        String r108 = UriProtector.getQueryParameter(r110, "conversation_id");
        if (r108 == null) goto L80;
        if (b(r108) == false) goto L44;
        String r109 = r108;
    L45:
        if (r109 == null) goto L80;
        a r111 = c(r110, r100, MusicAppletPage.KEY_MESSAGE_ID);
        if (r111 != null) goto L49;
        return null;
    L49:
        a r112 = c(r110, r100, "bot_id");
        if (r112 != null) goto L53;
        return null;
    L53:
        if (r100.contains("enter_from") == false) goto L68;
        String r113 = UriProtector.getQueryParameter(r110, "enter_from");
        if (r113 != null) goto L57;
    L67:
        return null;
    L57:
        if ((!StringsKt.isBlank(r113)) == true) goto L59;
    L61:
        r103 = false;
    L62:
        if (r103 == true) goto L65;
        r113 = null;
    L65:
        if (r113 == null) goto L67;
    L69:
        ContextWindowEnterFrom[] r114 = ContextWindowEnterFrom.values();
        int r115 = r114.length;
    L70:
        if (r104 >= r115) goto L75;
        ContextWindowEnterFrom r116 = r114[r104];
        if (Intrinsics.areEqual(r116.getWireValue(), r113) == true) goto L73;
        r104 = r104 + 1;
        goto L70
    L73:
        ContextWindowEnterFrom r117 = r116;
    L76:
        if (r117 != null) goto L79;
        return null;
    L79:
        return new ContextWindowEntryRequest(r109, r111.f552732a, r112.f552732a, r117, ContextWindowContainer.NATIVE_ROUTE);
    L75:
        r117 = null;
        goto L76
    L59:
        if (r113.length() > 32) goto L61;
    L68:
        r113 = ContextWindowEnterFrom.UNKNOWN.getWireValue();
        goto L69
    L44:
        r109 = null;
        goto L45
    L33:
        r106 = false;
    L36:
        r107 = false;
        goto L37
    L25:
        if (r102.isEmpty() == false) goto L27;
        goto L27
    }

    public static a c(Uri r100, Set r101, String r102) {
        if (r101.contains(r102) == false) goto L5;
        String r103 = UriProtector.getQueryParameter(r100, r102);
        if (r103 != null) goto L9;
    L15:
        return null;
    L9:
        if (b(r103) == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L15;
        return new a(r103);
    L5:
        return new a(null);
    }
}
