package cr5;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.AddV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.BatchAddV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.BatchMovV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.DelAndMovUpV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.DelV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.DesV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.MovV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.PinAddV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.PinDeleteV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.PinMoveV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.ReaV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.SpacePinAddV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.SpacePinDelV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.SpacePinMoveV1;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.UdeNodePermV3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.push.UdeV3;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final String a;
    public cr5.b b;
    public Handler c;
    public final String d;
    public volatile a e;
    public volatile b f;

    public interface a {
        void onAddHomePageV3(AddV3 r1);

        void onAddV3(AddV3 r1);

        void onBatchAddV3(BatchAddV3 r1);

        void onBatchMovV3(BatchMovV3 r1);

        void onDelAndMovUPV3(DelAndMovUpV3 r1);

        void onDelHomePageV3(DelV3 r1);

        void onDelV3(DelV3 r1);

        void onDesV3(DesV3 r1);

        void onMovV3(MovV3 r1);

        void onPinAdd(PinAddV1 r1);

        void onPinDelete(PinDeleteV1 r1);

        void onPinMove(PinMoveV1 r1);

        void onReaV3(ReaV3 r1);

        void onSpacePinAdd(SpacePinAddV1 r1);

        void onSpacePinDelete(SpacePinDelV1 r1);

        void onSpacePinMove(SpacePinMoveV1 r1);

        void onUdeNodePermV3(UdeNodePermV3 r1);

        void onUdeV3(UdeV3 r1);
    }

    public interface b {
        void a(String r1);
    }

    public static class c implements a {
        public c() {
        }

        @Override // cr5.d.a
        public final void onAddHomePageV3(AddV3 r1) {
        }

        @Override // cr5.d.a
        public final void onAddV3(AddV3 r1) {
        }

        @Override // cr5.d.a
        public final void onBatchAddV3(BatchAddV3 r1) {
        }

        @Override // cr5.d.a
        public final void onBatchMovV3(BatchMovV3 r1) {
        }

        @Override // cr5.d.a
        public final void onDelAndMovUPV3(DelAndMovUpV3 r1) {
        }

        @Override // cr5.d.a
        public final void onDelHomePageV3(DelV3 r1) {
        }

        @Override // cr5.d.a
        public final void onDelV3(DelV3 r1) {
        }

        @Override // cr5.d.a
        public final void onDesV3(DesV3 r1) {
        }

        @Override // cr5.d.a
        public final void onMovV3(MovV3 r1) {
        }

        @Override // cr5.d.a
        public final void onPinAdd(PinAddV1 r1) {
        }

        @Override // cr5.d.a
        public final void onPinDelete(PinDeleteV1 r1) {
        }

        @Override // cr5.d.a
        public final void onPinMove(PinMoveV1 r1) {
        }

        @Override // cr5.d.a
        public final void onReaV3(ReaV3 r1) {
        }

        @Override // cr5.d.a
        public final void onSpacePinAdd(SpacePinAddV1 r1) {
        }

        @Override // cr5.d.a
        public final void onSpacePinDelete(SpacePinDelV1 r1) {
        }

        @Override // cr5.d.a
        public final void onSpacePinMove(SpacePinMoveV1 r1) {
        }

        @Override // cr5.d.a
        public final void onUdeNodePermV3(UdeNodePermV3 r1) {
        }

        @Override // cr5.d.a
        public final void onUdeV3(UdeV3 r1) {
        }
    }

    public final void a() {
        tt5.a.h(this.a, "WikiPush detach. ");
        if (this.b == null) goto L6;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).lb(this.b);
        this.e = null;
        this.f = null;
        return;
    }

    public final void b(String r7) throws Exception {
        String r8 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r7), WikiFolderPushPlugin.DATA), "body"), WikiFolderPushPlugin.DATA);
        JSONObject r0 = new JSONObject(r8);
        String r1 = JSONObjectProtectorUtils.getString(r0, "op");
        boolean r2 = r0.optBoolean("too_many_coordinator");
        String r3 = r0.optString("synergy_uuid");
        tt5.a.h(this.a, "PushWrapper.parsePushJson, receive push, op: " + r1 + ", tooManyCoordinator: " + r2 + ", synergyUuid: " + r3);
        if (r2 == false) goto L7;
        tt5.a.k(this.a, "PushWrapper.parsePushJson, too many coordinator, ignore this push com.bytedance.ee.bear.lark.message. ");
        return;
    L7:
        if (TextUtils.equals(this.d, r3) == false) goto L10;
        tt5.a.k(this.a, "PushWrapper.parsePushJson, receive op by yourself, ignore this push. ");
        return;
    L10:
        Gson r4 = new Gson();
        r1.getClass();
        byte r5 = -1;
        switch(r1.hashCode()) {
            case -2021244179: goto L74;
            case -1666999398: goto L70;
            case -1617267517: goto L66;
            case -1530218215: goto L62;
            case -1422513445: goto L58;
            case -1335464143: goto L54;
            case -1335255606: goto L50;
            case -1263022736: goto L46;
            case -1068268664: goto L42;
            case -934983730: goto L38;
            case -849900634: goto L34;
            case -268582886: goto L30;
            case -37033256: goto L26;
            case 1607014812: goto L22;
            case 1694064114: goto L18;
            case 1961259593: goto L14;
            default: goto L77;
        };
    L77:
        switch(r5) {
            case 0: goto L104;
            case 1: goto L103;
            case 2: goto L102;
            case 3: goto L101;
            case 4: goto L95;
            case 5: goto L89;
            case 6: goto L88;
            case 7: goto L87;
            case 8: goto L86;
            case 9: goto L85;
            case 10: goto L84;
            case 11: goto L83;
            case 12: goto L82;
            case 13: goto L81;
            case 14: goto L80;
            case 15: goto L79;
            default: goto L78;
        };
    L78:
        tt5.a.k(this.a, "PushWrapper.parsePushJson, op not match any exist field. ");
        return;
    L79:
        this.e.onSpacePinMove((SpacePinMoveV1) GsonProtectorUtils.fromJson(r4, r8, SpacePinMoveV1.class));
        return;
    L80:
        this.e.onSpacePinDelete((SpacePinDelV1) GsonProtectorUtils.fromJson(r4, r8, SpacePinDelV1.class));
        return;
    L81:
        this.e.onSpacePinAdd((SpacePinAddV1) GsonProtectorUtils.fromJson(r4, r8, SpacePinAddV1.class));
        return;
    L82:
        this.e.onUdeNodePermV3((UdeNodePermV3) GsonProtectorUtils.fromJson(r4, r8, UdeNodePermV3.class));
        return;
    L83:
        this.e.onDelAndMovUPV3((DelAndMovUpV3) GsonProtectorUtils.fromJson(r4, r8, DelAndMovUpV3.class));
        return;
    L84:
        this.e.onUdeV3((UdeV3) GsonProtectorUtils.fromJson(r4, r8, UdeV3.class));
        return;
    L85:
        this.e.onReaV3((ReaV3) GsonProtectorUtils.fromJson(r4, r8, ReaV3.class));
        return;
    L86:
        this.e.onMovV3((MovV3) GsonProtectorUtils.fromJson(r4, r8, MovV3.class));
        return;
    L87:
        this.e.onPinMove((PinMoveV1) GsonProtectorUtils.fromJson(r4, r8, PinMoveV1.class));
        return;
    L88:
        this.e.onDesV3((DesV3) GsonProtectorUtils.fromJson(r4, r8, DesV3.class));
        return;
    L89:
        DelV3 r9 = (DelV3) GsonProtectorUtils.fromJson(r4, r8, DelV3.class);
        if (r9 != null) goto L92;
    L94:
        this.e.onDelV3(r9);
        return;
    L92:
        if (r9.isWikiHomePage == false) goto L94;
        this.e.onDelHomePageV3(r9);
        return;
    L95:
        AddV3 r10 = (AddV3) GsonProtectorUtils.fromJson(r4, r8, AddV3.class);
        if (r10 != null) goto L98;
    L100:
        this.e.onAddV3(r10);
        return;
    L98:
        if (r10.isWikiHomePage == false) goto L100;
        this.e.onAddHomePageV3(r10);
        return;
    L101:
        this.e.onPinDelete((PinDeleteV1) GsonProtectorUtils.fromJson(r4, r8, PinDeleteV1.class));
        return;
    L102:
        this.e.onPinAdd((PinAddV1) GsonProtectorUtils.fromJson(r4, r8, PinAddV1.class));
        return;
    L103:
        this.e.onBatchMovV3((BatchMovV3) GsonProtectorUtils.fromJson(r4, r8, BatchMovV3.class));
        return;
    L104:
        this.e.onBatchAddV3((BatchAddV3) GsonProtectorUtils.fromJson(r4, r8, BatchAddV3.class));
        return;
    L14:
        if (r1.equals("space_pin_mov_v1") == false) goto L77;
        r5 = 15;
        goto L77
    L18:
        if (r1.equals("space_pin_del_v1") == false) goto L77;
        r5 = 14;
        goto L77
    L22:
        if (r1.equals("space_pin_add_v1") == false) goto L77;
        r5 = 13;
        goto L77
    L26:
        if (r1.equals("ude_node_perm_v3") == false) goto L77;
        r5 = 12;
        goto L77
    L30:
        if (r1.equals("del_and_mov_up_v3") == false) goto L77;
        r5 = 11;
        goto L77
    L34:
        if (r1.equals("ude_v3") == false) goto L77;
        r5 = 10;
        goto L77
    L38:
        if (r1.equals("rea_v3") == false) goto L77;
        r5 = 9;
        goto L77
    L42:
        if (r1.equals("mov_v3") == false) goto L77;
        r5 = 8;
        goto L77
    L46:
        if (r1.equals("pin_mov_v1") == false) goto L77;
        r5 = 7;
        goto L77
    L50:
        if (r1.equals("des_v3") == false) goto L77;
        r5 = 6;
        goto L77
    L54:
        if (r1.equals("del_v3") == false) goto L77;
        r5 = 5;
        goto L77
    L58:
        if (r1.equals("add_v3") == false) goto L77;
        r5 = 4;
        goto L77
    L62:
        if (r1.equals("pin_del_v1") == false) goto L77;
        r5 = 3;
        goto L77
    L66:
        if (r1.equals("pin_add_v1") == false) goto L77;
        r5 = 2;
        goto L77
    L70:
        if (r1.equals("m_mov_v3") == false) goto L77;
        r5 = 1;
        goto L77
    L74:
        if (r1.equals("m_add_v3") == false) goto L77;
        r5 = 0;
        goto L77
    }

    public d(String r1, a r2, String r3, String r4) {
        this.a = "Wiki_WikiPush@";
        this.e = r2;
        this.d = r3;
        this.a = "Wiki_WikiPush@" + r4;
    }
}
