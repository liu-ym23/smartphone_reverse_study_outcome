package gt2;

import android.text.TextPaint;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.share.ConversationCoreInfo;
import com.bytedance.android.livesdk.share.adapter.FansGroupAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f482498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FansGroupAdapter f482499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ConversationCoreInfo f482500c;

    public a(TextView r100, FansGroupAdapter r101, ConversationCoreInfo r102) {
        this.f482498a = r100;
        this.f482499b = r101;
        this.f482500c = r102;
    }

    public final void a() {
        if (this.f482498a.getLayout() != null) goto L6;
        return;
    L6:
        if (this.f482500c != null) goto L8;
        return;
    L8:
        TextView r100 = this.f482498a;
        FansGroupAdapter r101 = this.f482499b;
        int r102 = (int) s1.e(58.0f);
        int r103 = this.f482498a.getLayout().getLineStart(1);
        int r104 = this.f482498a.getLayout().getLineEnd(1);
        TextPaint r105 = this.f482498a.getPaint();
        String r106 = "(" + this.f482500c.memberCount + ')';
        String r107 = this.f482500c.name;
        int r108 = FansGroupAdapter.f158075e;
        r101.getClass();
        if (r107.length() != 0) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == false) goto L14;
    L41:
        String r110 = "";
    L42:
        r100.setText(r110);
        return;
    L14:
        if (r106.length() != 0) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == true) goto L41;
        r110 = r107.concat(r106);
        int r112 = r110.length();
        if (r104 >= r112) goto L42;
        if (r103 >= r112) goto L42;
        if (r103 >= r107.length()) goto L42;
        StringBuilder r113 = new StringBuilder();
        String r114 = r107.substring(r103);
        float r115 = r102 - r105.measureText("...".concat(r106));
        int r116 = 0;
    L27:
        if (r105.measureText(r113.toString()) >= r115) goto L34;
        int r117 = r114.length();
        if (r116 < 0) goto L34;
        if (r117 <= r116) goto L34;
        r113.append(r114.charAt(r116));
        r116 = r116 + 1;
    L34:
        if (r105.measureText(r113.toString()) < r115) goto L37;
        r113.deleteCharAt(r113.length() - 1);
    L37:
        if (r113.length() == r114.length()) goto L40;
        r106 = "...".concat(r106);
    L40:
        r110 = r107.substring(0, r103) + r113 + r106;
        goto L42
    L16:
        r111 = false;
        goto L17
    L11:
        r109 = false;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
