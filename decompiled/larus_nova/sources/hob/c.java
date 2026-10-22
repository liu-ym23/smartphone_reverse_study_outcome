package hob;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f486307k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f486309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f486310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f486311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f486312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f486313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RichTextElement.AtProperty f486314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f486315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f486316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f486317j;

    public static final class a {
        @JvmStatic
        public static c a(RichTextElement.AtProperty r100) {
            Intrinsics.checkNotNullParameter(r100, "atProperty");
            String r101 = r100.getUserId();
            if (r101 != null) goto L5;
            String r102 = "";
        L6:
            String r103 = r100.getAtContent();
            if (r103 == null) goto L12;
            String r104 = r103.substring(1);
            if (r104 == null) goto L12;
            String r105 = r104;
        L13:
            String r106 = r100.getOriginUserName();
            if (r106 != null) goto L16;
            String r107 = "";
        L17:
            String r108 = r102;
            String r109 = r105;
            String r110 = r107;
            c r111 = new c(r108, r109, r110, r100.isOutChatUser(), r100.isAnonymous());
            r111.f486314g = r100;
            r111.f486317j = r100.isHighLight();
            return r111;
        L16:
            r107 = r106;
        L12:
            r105 = "";
            goto L13
        L5:
            r102 = r101;
            goto L6
        }
    }

    static {
    }

    public c(String r100, String r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "chatterName");
        Intrinsics.checkNotNullParameter(r102, "chatterOriginName");
        this.f486308a = r100;
        this.f486309b = r101;
        this.f486310c = r102;
        this.f486311d = r103;
        this.f486312e = r104;
        this.f486313f = true;
    }
}
