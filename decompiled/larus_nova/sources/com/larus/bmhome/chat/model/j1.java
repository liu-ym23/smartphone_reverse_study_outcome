package com.larus.bmhome.chat.model;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;

/* JADX INFO: loaded from: classes25.dex */
public interface j1 {

    public static final class a {
        public static /* synthetic */ boolean b(j1 r100, List r110, boolean r111, boolean r112, String r113, String r114, Long r115, int r116) {
            if ((r116 & 2) == 0) goto L5;
            boolean r101 = false;
        L7:
            if ((r116 & 4) == 0) goto L9;
            boolean r102 = false;
        L11:
            if ((r116 & 8) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r116 & 16) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r116 & 32) == 0) goto L21;
            Long r105 = null;
        L23:
            return r100.s(r110, r101, r102, r103, r104, r105);
        L21:
            r105 = r115;
            goto L23
        L17:
            r104 = r114;
            goto L19
        L13:
            r103 = r113;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }

        public static /* synthetic */ boolean c(j1 r100, String r101, String r102, boolean r110, Long r111, String r112, String r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            r101 = "";
        L5:
            String r103 = r101;
            if ((r114 & 4) == 0) goto L8;
            boolean r104 = false;
        L10:
            if ((r114 & 8) == 0) goto L12;
            Long r105 = null;
        L14:
            if ((r114 & 16) == 0) goto L16;
            String r106 = null;
        L18:
            if ((r114 & 32) == 0) goto L20;
            String r107 = null;
        L22:
            return r100.g(r103, r102, r104, r105, r106, r107);
        L20:
            r107 = r113;
            goto L22
        L16:
            r106 = r112;
            goto L18
        L12:
            r105 = r111;
            goto L14
        L8:
            r104 = r110;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(j1 r110, String r111, UplinkFileEntity r112, List r113, boolean r114, boolean r115, String r116, String r210, Long r211, String r212, int r213) {
            if ((r213 & 2) == 0) goto L5;
            UplinkFileEntity r100 = null;
        L7:
            if ((r213 & 4) == 0) goto L9;
            List r101 = null;
        L11:
            if ((r213 & 8) == 0) goto L13;
            boolean r102 = false;
        L15:
            if ((r213 & 16) == 0) goto L17;
            boolean r103 = false;
        L19:
            if ((r213 & 32) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r213 & 64) == 0) goto L25;
            String r117 = null;
        L27:
            if ((r213 & 128) == 0) goto L29;
            Long r118 = null;
        L31:
            if ((r213 & 256) == 0) goto L33;
            String r119 = null;
        L35:
            return r110.e(r111, r100, r101, r102, r103, r104, r117, r118, r119);
        L33:
            r119 = r212;
            goto L35
        L29:
            r118 = r211;
            goto L31
        L25:
            r117 = r210;
            goto L27
        L21:
            r104 = r116;
            goto L23
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    int a();

    void b(boolean r100);

    void c(String r100, String r101, Long r102);

    ChatDraftItem d();

    boolean e(String r100, UplinkFileEntity r101, List<UplinkFileEntity> r102, boolean r103, boolean r104, String r105, String r106, Long r107, String r108);

    ChatDraftItem f();

    boolean g(String r100, String r101, boolean r102, Long r103, String r104, String r105);

    void h();

    void i();

    void j(List<String> r100);

    void k(List<String> r100);

    void l(String r100);

    ChatDraftItem m();

    void n();

    List<String> o();

    boolean p();

    void q();

    List<String> r();

    boolean s(List<ChatDraftItem> r100, boolean r101, boolean r102, String r103, String r104, Long r105);

    void t(String r100, String r101);

    boolean u(ChatDraftItem r100);
}
