package tx9;

/* JADX INFO: loaded from: classes31.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547889a = 0;

    static {
    }

    public static String a(boolean r100, boolean r101, boolean r102, boolean r103) {
        if (r100 == true) goto L5;
        return "normal_create";
    L5:
        if (r101 == true) goto L9;
        if (r102 == true) goto L9;
        if (r103 == true) goto L9;
        return "compensate_no_real_token_no_user_changes_no_frontend_linked";
    L9:
        if (r101 == true) goto L13;
        if (r102 == true) goto L13;
        if (r103 == false) goto L13;
        return "compensate_no_real_token_no_user_changes_frontend_linked";
    L13:
        if (r101 == true) goto L17;
        if (r102 == false) goto L17;
        if (r103 == true) goto L17;
        return "compensate_no_real_token_user_changes_no_frontend_linked";
    L17:
        if (r101 == true) goto L21;
        if (r102 == false) goto L21;
        if (r103 == false) goto L21;
        return "compensate_no_real_token_user_changes_frontend_linked";
    L21:
        if (r101 == false) goto L25;
        if (r102 == true) goto L25;
        if (r103 == true) goto L25;
        return "compensate_real_token_no_user_changes_no_frontend_linked";
    L25:
        if (r101 == false) goto L29;
        if (r102 == true) goto L29;
        if (r103 == false) goto L29;
        return "compensate_real_token_no_user_changes_frontend_linked";
    L29:
        if (r101 == false) goto L33;
        if (r102 == false) goto L33;
        if (r103 == true) goto L33;
        return "compensate_real_token_user_changes_no_frontend_linked";
    L33:
        return "compensate_real_token_user_changes_frontend_linked";
    }
}
