package zg1;

import android.text.TextUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class r2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f571921l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f571923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f571925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f571926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f571927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f571928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f571929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f571930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f571931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f571932k;

    static {
        HashSet r100 = new HashSet();
        f571921l = r100;
        r100.add(PbRequest.SwitchType.PK);
        r100.add(UserProfileEvent.SOURCE_ANCHOR_AVATAR);
        r100.add("audience_linkmic");
        r100.add("anchor_linkmic");
        r100.add("audience_audio");
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (((HashSet) f571921l).contains(r100) == false) goto L7;
        return true;
    }

    public r2(String r100, long r101, String r102) {
        this.f571922a = r100;
        this.f571923b = r101;
        this.f571924c = r102;
    }

    public r2(String r100, long r101, String r102, String r103, String r104, String r105, String r106, boolean r107) {
        this.f571922a = r100;
        this.f571923b = r101;
        this.f571924c = r102;
        this.f571925d = r103;
        this.f571926e = r104;
        this.f571927f = r105;
        this.f571928g = r106;
        this.f571929h = r107;
    }
}
