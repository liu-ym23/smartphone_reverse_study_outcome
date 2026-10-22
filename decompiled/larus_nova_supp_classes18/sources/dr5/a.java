package dr5;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final Gson a = null;

    /* JADX INFO: renamed from: dr5.a$a, reason: collision with other inner class name */
    public static final class C0226a {
        @JvmStatic
        public static void a(j r4, ImageView r5) {
            Intrinsics.checkNotNullParameter(r4, "node");
            Intrinsics.checkNotNullParameter(r5, "indicator");
            b r0 = new b();     // Catch: Exception -> L27
            r0.b(Boolean.valueOf(r4.p));     // Catch: Exception -> L27
            Gson r1 = a.a;     // Catch: Exception -> L27
            if (r4.h != (-5)) goto L6;
            boolean r2 = true;
        L7:
            if (r2 == false) goto L21;
            String r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r4.n, 0);     // Catch: Exception -> L27
            if (c.a(r3) == false) goto L13;
            String r6 = "clipDocument";
        L23:
            if (TextUtils.isEmpty(r6) == true) goto L25;
            r0.a(r6);     // Catch: Exception -> L27
        L25:
            r5.setContentDescription(a.a.toJson(r0));     // Catch: Exception -> L27
            return;
        L13:
            if (TextUtils.equals("wikiroot%top_wiki_token", r3) == false) goto L16;
            r6 = "clipWikiSpace";
            goto L23
        L16:
            if (c.b(r4) == false) goto L19;
            r6 = WikiSpaceType.PERSONAL;
            goto L23
        L19:
            if (TextUtils.equals("wikiroot%title_root_share_token", r3) == false) goto L21;
            r6 = "shared";
        L21:
            r6 = null;
            goto L23
        L6:
            r2 = false;
        L27:
            e = move-exception;
            tt5.a.d("WikiTreeItemAutomate", "addTreeItemTag fail: " + e);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/automate/WikiTreeItemAutomate$WikiItemAutomate;", "", "<init>", "()V", "status", "", "getStatus", "()Ljava/lang/Boolean;", "setStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("scene")
        private String scene;

        @SerializedName("status")
        private Boolean status;

        public b() {
        }

        public final void a(String r1) {
            this.scene = r1;
        }

        public final void b(Boolean r1) {
            this.status = r1;
        }
    }

    static {
        a = new Gson();
    }
}
