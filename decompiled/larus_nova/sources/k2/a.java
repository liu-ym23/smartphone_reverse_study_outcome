package k2;

import android.net.Uri;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: k2.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6503a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f501421a = null;

        static {
            int[] r100 = new int[PageType.values().length];
            r100[PageType.FULL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PageType.POPUP_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f501421a = r100;
        }
    }

    public static final String a(PageInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getPageUrl();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L24;
        String r104 = r100.getPageUrl();
        Intrinsics.checkNotNull(r104);
        ReadableMap r105 = r100.getPageSettings();
        Intrinsics.checkNotNullParameter(r104, "uri");
        h2.a r106 = f2.b.f475099c;
        if (r106 != null) goto L14;
    L16:
        if (r102 == true) goto L26;
        if (r105 == null) goto L26;
        Uri.Builder r107 = UriProtector.parse(r104).buildUpon();
        ReadableMapKeySetIterator r108 = r105.keySetIterator();
    L21:
        if (r108.hasNextKey() == false) goto L23;
        String r109 = r108.nextKey();
        r107.appendQueryParameter(r109, r105.getString(r109));
        goto L21
    L23:
        r104 = r107.build().toString();
    L26:
        return r104;
    L14:
        if (r106.f483571j != true) goto L16;
        r102 = true;
        goto L16
    L24:
        return r100.getPageUrl();
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
