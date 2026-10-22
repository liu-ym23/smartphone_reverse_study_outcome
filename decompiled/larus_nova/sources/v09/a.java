package v09;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: classes27.dex */
public interface a extends t1a.a {

    /* JADX INFO: renamed from: v09.a$a, reason: collision with other inner class name */
    public static final class C7952a {
        public static /* synthetic */ void a(a r100, ICoreInputAbility.OnSendParams r101, String r102, String r103, boolean r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = "";
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = "";
        L12:
            if ((r105 & 8) == 0) goto L14;
            r104 = false;
        L14:
            r100.C7(r101, r102, r103, r104);
        }
    }

    void C7(ICoreInputAbility.OnSendParams r100, String r101, String r102, boolean r103);

    int K7();

    void T9(boolean r100);

    void h6();

    void u9();
}
