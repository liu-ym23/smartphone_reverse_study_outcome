package un5;

import android.content.Context;
import android.text.TextPaint;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class e extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f550785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f550786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f550787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f550788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f550789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f550790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f550791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f550792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f550793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f550794l;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    public final boolean g1() {
        return false;
    }

    public int getType() {
        return this.f550788f;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        int r101 = this.f550785c.getResources().getColor(R.color.text_link_normal);
        int r102 = this.f550773b;
        if (r102 == (-1)) goto L6;
        r101 = r102;
    L8:
        r100.setColor(r101);
        return;
    L6:
        if (this.f550793k == false) goto L8;
        r101 = this.f550785c.getResources().getColor(R.color.lkui_N400);
        goto L8
    }

    public e(Context r100, String r101, int r102, int r103, String r104, String r105, int r106, String r107, String r108, a.InterfaceC7903a r110) {
        this.f550785c = r100;
        this.f550786d = r101;
        this.f550788f = r102;
        this.f550789g = r103;
        this.f550787e = r104;
        this.f550792j = r106;
        this.f550791i = r107;
        this.f550790h = r108;
        this.f550772a = r110;
        this.f550794l = r105;
    }
}
