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

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f469776a = null;

    /* JADX INFO: renamed from: dr5.a$a, reason: collision with other inner class name */
    public static final class C5703a {
        @JvmStatic
        public static void a(j r100, ImageView r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "indicator");
            b r102 = new b();     // Catch: Exception -> L27
            r102.b(Boolean.valueOf(r100.f241928p));     // Catch: Exception -> L27
            Gson r103 = a.f469776a;     // Catch: Exception -> L27
            if (r100.f241920h != (-5)) goto L6;
            boolean r104 = true;
        L7:
            if (r104 == false) goto L21;
            String r105 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r100.f241926n, 0);     // Catch: Exception -> L27
            if (c.a(r105) == false) goto L13;
            String r106 = "clipDocument";
        L23:
            if (TextUtils.isEmpty(r106) == true) goto L25;
            r102.a(r106);     // Catch: Exception -> L27
        L25:
            r101.setContentDescription(a.f469776a.toJson(r102));     // Catch: Exception -> L27
            return;
        L13:
            if (TextUtils.equals("wikiroot%top_wiki_token", r105) == false) goto L16;
            r106 = "clipWikiSpace";
            goto L23
        L16:
            if (c.b(r100) == false) goto L19;
            r106 = WikiSpaceType.PERSONAL;
            goto L23
        L19:
            if (TextUtils.equals("wikiroot%title_root_share_token", r105) == false) goto L21;
            r106 = "shared";
        L21:
            r106 = null;
            goto L23
        L6:
            r104 = false;
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

        public final void a(String r100) {
            this.scene = r100;
        }

        public final void b(Boolean r100) {
            this.status = r100;
        }
    }

    static {
        f469776a = new Gson();
    }
}
