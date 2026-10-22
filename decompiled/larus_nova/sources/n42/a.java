package n42;

import android.graphics.Rect;
import android.graphics.Typeface;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f517038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Typeface f517039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f517040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f517041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f517042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f517043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f517044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f517045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f517046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f517047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f517048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f517049l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MessageSceneType f517050m;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("TextMessageStyleConfig{messageTextSizeInPx=");
        r100.append(this.f517038a);
        r100.append(", messageTypeface=");
        Typeface r101 = this.f517039b;
        String r102 = "null";
        if (r101 != null) goto L5;
        Object r103 = "null";
    L6:
        r100.append(r103);
        r100.append(", messageMinHeight=");
        r100.append(this.f517040c);
        r100.append(", messagePadding=");
        Rect r104 = this.f517041d;
        if (r104 != null) goto L9;
        String r105 = "null";
    L10:
        r100.append(r105);
        r100.append(", countTextSizeInPx=");
        r100.append(this.f517046i);
        r100.append(", countTextColor=");
        r100.append(this.f517047j);
        r100.append(", countTextMinHeight=");
        r100.append(this.f517048k);
        r100.append(", countTextBackgroundResId=");
        r100.append(this.f517049l);
        r100.append(", textSceneType=");
        MessageSceneType r106 = this.f517050m;
        if (r106 == null) goto L14;
        r102 = r106.toString();
    L14:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L9:
        r105 = r104.toString();
        goto L10
    L5:
        r103 = Integer.valueOf(r101.getStyle());
        goto L6
    }

    public a() {
        this.f517042e = false;
        this.f517043f = false;
        this.f517044g = null;
        this.f517045h = null;
        int r100 = MessageCommonColorUtil.f133766a;
        MessageCommonColorUtil.d();
        MessageCommonColorUtil.d();
    }
}
