package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashMap;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class Migration40_41 extends Migration {
    public Migration40_41() {
        super(40, 41);
    }

    public final void a(Cursor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isClosed() == true) goto L8;
        r100.close();
        return;
    }

    public final void b(SupportSQLiteDatabase r510) {
        HashMap r100 = new HashMap();
        Cursor r101 = r510.query("select * from ManualOfflineDoc");
        String r102 = "thumbnail_secret";
        String r110 = "create_tenant_id";
        String r111 = "extra";
        String r112 = "create_time";
        String r103 = "edit_time";
        String r104 = "url";
        HashMap r113 = r100;
        String r105 = "type";
        String r114 = "document_icon_type";
        String r106 = "name";
        String r115 = "document_icon_key";
        String r107 = DocCallbackImpl.KEY_THUMBNAIL;
        String r116 = "thumbnail_type";
        String r108 = "obj_token";
        String r210 = "thumbnail_nonce";
        if (r101 != null) goto L5;
    L30:
        String r211 = "name";
        String r109 = DocCallbackImpl.KEY_THUMBNAIL;
        String r117 = "extra";
        String r118 = "type";
        String r119 = "url";
        String r120 = "create_time";
        HashMap r121 = r113;
        String r122 = "thumbnail_secret";
        SupportSQLiteDatabase r123 = r510;
        String r124 = "edit_time";
    L31:
        a(r101);
        r123.execSQL("DROP TABLE IF EXISTS `ManualOfflineDoc`");
        Cursor r125 = r123.query("select * from OfflineOperateDoc");
        String r212 = "thumbnail_url";
        String r126 = "edit_uid";
        if (r125 != null) goto L34;
    L52:
        String r213 = "create_tenant_id";
        String r310 = r119;
        String r127 = r211;
        HashMap r214 = r121;
        String r128 = r124;
        SupportSQLiteDatabase r129 = r123;
    L53:
        a(r125);
        r129.execSQL("DROP TABLE IF EXISTS `OfflineOperateDoc`");
        Cursor r130 = r129.query("select * from PinedDoc");
        if (r130 != null) goto L56;
    L77:
        String r311 = r128;
        Cursor r410 = r130;
        String r131 = r117;
        String r411 = r120;
        String r132 = "edit_uid";
        String r133 = r114;
        String r134 = r115;
        String r511 = r210;
        String r135 = r213;
        String r136 = r109;
        String r215 = r122;
    L78:
        r129.execSQL("DROP TABLE IF EXISTS `PinedDoc`");
        a(r410);
        Cursor r137 = r129.query("select * from RecentDoc");
        if (r137 != null) goto L81;
    L102:
        Cursor r512 = r137;
        SupportSQLiteDatabase r138 = r129;
    L103:
        r138.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
        a(r512);
        Cursor r139 = r138.query("select * from StatusDoc");
        if (r139 != null) goto L106;
    L114:
        r138.execSQL("DROP TABLE IF EXISTS `StatusDoc`");
        a(r139);
        r138.execSQL("DROP TABLE IF EXISTS `MineDoc`");
        r138.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
        r138.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
        r138.execSQL("DROP TABLE IF EXISTS `StarDoc`");
        r138.execSQL("DROP TABLE IF EXISTS `TrashDoc`");
        r138.execSQL("DROP TABLE IF EXISTS `RecentPull`");
        return;
    L106:
        if (r139.moveToFirst() == false) goto L114;
    L107:
        String r140 = r139.getString(r139.getColumnIndex("doc_token"));
        int r141 = r139.getInt(r139.getColumnIndex("doc_cache_status"));
        ContentValues r142 = new ContentValues();
        r142.put(r108, r140);
        r142.put("doc_cache_status", Integer.valueOf(r141));
        String r143 = r108;
        if (r510.update("DocMetaInfo", 5, r142, "obj_token=?", new String[]{r140}) > 0) goto L111;
        r138.insert("DocMetaInfo", 4, r142);
    L111:
        if (r139.moveToNext() == false) goto L114;
        r108 = r143;
        goto L107
    L81:
        if (r137.moveToFirst() == false) goto L102;
    L82:
        String r144 = r137.getString(r137.getColumnIndex(r108));
        r137.getString(r137.getColumnIndex("userid"));
        r137.getString(r137.getColumnIndex("filepath"));
        String r145 = r137.getString(r137.getColumnIndex(r127));
        String r146 = r137.getString(r137.getColumnIndex(r118));
        String r216 = r118;
        String r147 = r137.getString(r137.getColumnIndex("owner_id"));
        String r148 = r137.getString(r137.getColumnIndex(r135));
        String r217 = r135;
        String r149 = r137.getString(r137.getColumnIndex("creator_cn_name"));
        String r150 = r137.getString(r137.getColumnIndex("creator_en_name"));
        String r151 = r137.getString(r137.getColumnIndex(r132));
        String r218 = r132;
        String r152 = r137.getString(r137.getColumnIndex(r311));
        String r153 = r137.getString(r137.getColumnIndex(r310));
        String r154 = r137.getString(r137.getColumnIndex("fake_token"));
        if (r137.getInt(r137.getColumnIndex("is_external")) != 1) goto L85;
        boolean r155 = true;
    L86:
        boolean r312 = r155;
        if (r137.getInt(r137.getColumnIndex(EventConstants.ExtraJson.EXTRA_IS_STAR)) != 1) goto L89;
        boolean r156 = true;
    L90:
        boolean r313 = r156;
        if (r137.getInt(r137.getColumnIndex("is_pine")) != 1) goto L93;
        boolean r157 = true;
    L94:
        String r158 = r137.getString(r137.getColumnIndex("open_time"));
        String r159 = r137.getString(r137.getColumnIndex(PushAction$ESubType.KEY_NAME));
        String r160 = r137.getString(r137.getColumnIndex(r131));
        String r412 = r131;
        String r161 = r137.getString(r137.getColumnIndex("icon_url"));
        String r162 = r137.getString(r137.getColumnIndex("icon_key"));
        String r163 = r137.getString(r137.getColumnIndex("icon_nonce"));
        int r164 = r137.getInt(r137.getColumnIndex("icon_encrypted_type"));
        String r165 = r137.getString(r137.getColumnIndex(r136));
        String r413 = r136;
        String r166 = r137.getString(r137.getColumnIndex(r411));
        String r167 = r137.getString(r137.getColumnIndex("my_edit_time"));
        String r168 = r137.getString(r137.getColumnIndex("activity_time"));
        if (r137.getInt(r137.getColumnIndex("copiable")) != 1) goto L97;
        boolean r219 = true;
    L98:
        String r169 = r137.getString(r137.getColumnIndex(r212));
        String r170 = r215;
        String r220 = r212;
        String r171 = r137.getString(r137.getColumnIndex(r170));
        String r172 = r511;
        String r173 = r137.getString(r137.getColumnIndex(r172));
        String r174 = r116;
        int r175 = r137.getInt(r137.getColumnIndex(r174));
        String r176 = r137.getString(r137.getColumnIndex(r134));
        int r177 = r137.getInt(r137.getColumnIndex(r133));
        String r513 = r133;
        String r178 = r137.getString(r137.getColumnIndex("document_icon_fsunit"));
        r512 = r137;
        ContentValues r179 = new ContentValues();
        r179.put(r108, r144);
        r179.put(r127, r145);
        r179.put(r216, r146);
        r179.put("owner_id", r147);
        r179.put(r217, r148);
        r179.put("creator_cn_name", r149);
        r179.put("creator_en_name", r150);
        r179.put(r218, r151);
        r179.put(r311, r152);
        r179.put(r310, r153);
        r179.put("fake_token", r154);
        r179.put("is_stared", Boolean.valueOf(r313));
        r179.put("is_pined", Boolean.valueOf(r157));
        r179.put("extra_icon_url", r161);
        r179.put("extra_icon_key", r162);
        r179.put("extra_icon_nonce", r163);
        r179.put("extra_icon_encrypted_type", Integer.valueOf(r164));
        r179.put(r413, r165);
        r179.put("extra_copiable", Boolean.valueOf(r219));
        r179.put("extra_is_external", Boolean.valueOf(r312));
        r179.put("extra_sub_type", r159);
        r179.put(r411, r166);
        r179.put(r220, r169);
        r212 = r220;
        r179.put(r170, r171);
        r215 = r170;
        r179.put(r172, r173);
        r179.put(r174, Integer.valueOf(r175));
        r511 = r172;
        r179.put("size", (String) r214.get(r144));
        r179.put(r413, r165);
        r179.put(r134, r176);
        r179.put(r513, Integer.valueOf(r177));
        r179.put("document_icon_fsunit", r178);
        r138 = r510;
        r138.insert("DocMetaInfo", 5, r179);
        ContentValues r180 = new ContentValues();
        r180.put(r108, r144);
        r180.put("list_type", 1);
        r180.put(r412, r160);
        r180.put("open_time_recent", r158);
        r180.put("my_edit_time_recent", r167);
        r180.put("activity_time_recent", r168);
        r138.insert("ListTypes", 5, r180);
        if (r512.moveToNext() == false) goto L103;
        r135 = r217;
        r116 = r174;
        r132 = r218;
        r137 = r512;
        r136 = r413;
        r131 = r412;
        r133 = r513;
        r118 = r216;
        goto L82
    L97:
        r219 = false;
        goto L98
    L93:
        r157 = false;
        goto L94
    L89:
        r156 = false;
        goto L90
    L85:
        r155 = false;
        goto L86
    L56:
        if (r130.moveToFirst() == false) goto L77;
    L57:
        String r181 = r130.getString(r130.getColumnIndex(r108));
        r130.getString(r130.getColumnIndex("user_id"));
        String r182 = r130.getString(r130.getColumnIndex(r127));
        String r183 = r130.getString(r130.getColumnIndex(r118));
        if (r130.getInt(r130.getColumnIndex("is_pined")) != 1) goto L60;
        boolean r184 = true;
    L61:
        String r185 = r130.getString(r130.getColumnIndex(r126));
        boolean r221 = r184;
        String r186 = r130.getString(r130.getColumnIndex(r128));
        String r187 = r130.getString(r130.getColumnIndex("owner_id"));
        r311 = r128;
        String r188 = r130.getString(r130.getColumnIndex("creator_en_name"));
        String r222 = r126;
        String r189 = r130.getString(r130.getColumnIndex("creator_cn_name"));
        String r190 = r130.getString(r130.getColumnIndex(r120));
        r411 = r120;
        String r191 = r130.getString(r130.getColumnIndex("tenant_id"));
        String r192 = r130.getString(r130.getColumnIndex(DocViewModel.EXTRA_SPACE_ID));
        String r193 = r130.getString(r130.getColumnIndex("share_root"));
        if (r130.getInt(r130.getColumnIndex("is_stared")) != 1) goto L64;
        boolean r194 = true;
    L65:
        boolean r314 = r194;
        if (r130.getInt(r130.getColumnIndex("is_external")) != 1) goto L68;
        boolean r315 = true;
    L69:
        String r195 = r130.getString(r130.getColumnIndex(r109));
        String r414 = r109;
        String r196 = r130.getString(r130.getColumnIndex(r310));
        String r197 = r130.getString(r130.getColumnIndex(PushAction$ESubType.KEY_NAME));
        String r198 = r130.getString(r130.getColumnIndex(r117));
        String r415 = r117;
        if (r130.getInt(r130.getColumnIndex("copiable")) != 1) goto L72;
        boolean r199 = true;
    L73:
        int r200 = r130.getInt(r130.getColumnIndex("share_version"));
        String r201 = r212;
        boolean r223 = r199;
        String r202 = r130.getString(r130.getColumnIndex(r201));
        String r203 = r122;
        String r204 = r130.getString(r130.getColumnIndex(r203));
        String r205 = r210;
        String r206 = r130.getString(r130.getColumnIndex(r205));
        r511 = r205;
        String r207 = r116;
        int r208 = r130.getInt(r130.getColumnIndex(r207));
        String r209 = r115;
        String r224 = r130.getString(r130.getColumnIndex(r209));
        String r225 = r114;
        int r226 = r130.getInt(r130.getColumnIndex(r225));
        String r227 = r130.getString(r130.getColumnIndex("document_icon_fsunit"));
        r410 = r130;
        ContentValues r228 = new ContentValues();
        r228.put(r108, r181);
        r228.put(r127, r182);
        r228.put(r118, r183);
        r228.put("owner_id", r187);
        r135 = r213;
        r228.put(r135, r191);
        r228.put("creator_cn_name", r189);
        r228.put("creator_en_name", r188);
        r132 = r222;
        r228.put(r132, r185);
        r228.put(r311, r186);
        r228.put(r310, r196);
        r228.put("is_stared", Boolean.valueOf(r314));
        r228.put("is_pined", Boolean.valueOf(r221));
        r136 = r414;
        r228.put(r136, r195);
        r228.put("extra_copiable", Boolean.valueOf(r223));
        r228.put("extra_is_external", Boolean.valueOf(r315));
        r228.put("extra_sub_type", r197);
        r228.put(r411, r190);
        r228.put(r201, r202);
        r212 = r201;
        r228.put(r203, r204);
        r215 = r203;
        r228.put(r511, r206);
        r228.put(r207, Integer.valueOf(r208));
        r116 = r207;
        r228.put("size", (String) r214.get(r181));
        r228.put(r136, r195);
        r134 = r209;
        r228.put(r134, r224);
        r133 = r225;
        r228.put(r133, Integer.valueOf(r226));
        r228.put("document_icon_fsunit", r227);
        r228.put("share_version", Integer.valueOf(r200));
        r228.put("extra_is_share_root", r193);
        r129 = r510;
        r129.insert("DocMetaInfo", 5, r228);
        ContentValues r229 = new ContentValues();
        r229.put(r108, r181);
        r229.put("list_type", 5);
        r131 = r415;
        r229.put(r131, r198);
        r229.put(DocViewModel.EXTRA_SPACE_ID, r192);
        r129.insert("ListTypes", 5, r229);
        if (r410.moveToNext() == false) goto L78;
        r213 = r135;
        r117 = r131;
        r114 = r133;
        r115 = r134;
        r109 = r136;
        r122 = r215;
        r128 = r311;
        r120 = r411;
        r130 = r410;
        r210 = r511;
        r126 = r132;
        goto L57
    L72:
        r199 = false;
        goto L73
    L68:
        r315 = false;
        goto L69
    L64:
        r194 = false;
        goto L65
    L60:
        r184 = false;
        goto L61
    L34:
        if (r125.moveToFirst() == false) goto L52;
    L36:
        String r230 = r125.getString(r125.getColumnIndex("fakeToken"));
        if (r125.getInt(r125.getColumnIndex("needSync")) != 1) goto L39;
        boolean r231 = true;
    L40:
        String r1100 = r125.getString(r125.getColumnIndex("filepath"));
        r127 = r211;
        r214 = r121;
        String r232 = r125.getString(r125.getColumnIndex(r127));
        boolean r233 = r231;
        String r234 = r125.getString(r125.getColumnIndex("token"));
        String r235 = r125.getString(r125.getColumnIndex(r118));
        String r236 = r125.getString(r125.getColumnIndex("owner_id"));
        String r237 = r125.getString(r125.getColumnIndex(r110));
        String r238 = r125.getString(r125.getColumnIndex(r120));
        String r239 = r125.getString(r125.getColumnIndex("creator_cn_name"));
        String r416 = r120;
        String r240 = r125.getString(r125.getColumnIndex("creator_en_name"));
        String r241 = r125.getString(r125.getColumnIndex("edit_uid"));
        String r242 = r125.getString(r125.getColumnIndex(r124));
        String r316 = r124;
        String r243 = r125.getString(r125.getColumnIndex(r108));
        String r244 = r125.getString(r125.getColumnIndex(r119));
        String r245 = r125.getString(r125.getColumnIndex(PushAction$ESubType.KEY_NAME));
        String r317 = r119;
        if (r125.getInt(r125.getColumnIndex("offline_create")) != 1) goto L43;
        boolean r246 = true;
    L44:
        String r1101 = r125.getString(r125.getColumnIndex(r117));
        if (TextUtils.isEmpty(r243) == false) goto L48;
        r243 = r230;
    L48:
        ContentValues r247 = new ContentValues();
        r247.put(r108, r243);
        r247.put(r127, r232);
        r247.put(r118, r235);
        r247.put("owner_id", r236);
        r247.put(r110, r237);
        r247.put("creator_cn_name", r239);
        r247.put("creator_en_name", r240);
        r247.put("edit_uid", r241);
        r128 = r316;
        r247.put(r128, r242);
        r247.put(r317, r244);
        r213 = r110;
        r247.put("fake_token", r230);
        r247.put("is_offline_create", Boolean.valueOf(r246));
        r247.put("extra_sub_type", r245);
        r247.put("need_sync", Boolean.valueOf(r233));
        r120 = r416;
        r247.put(r120, r238);
        r247.put("size", (String) r214.get(r243));
        r129 = r510;
        r310 = r317;
        r129.insert("DocMetaInfo", 5, r247);
        ContentValues r248 = new ContentValues();
        r248.put(r108, r243);
        r248.put("list_type", 9);
        r248.put("token", r234);
        r248.put(r117, r1101);
        r248.put("file_path", r1100);
        r129.insert("ListTypes", 5, r248);
        if (r125.moveToNext() == false) goto L50;
        r124 = r128;
        r121 = r214;
        r110 = r213;
        r119 = r310;
        r125 = r125;
        r211 = r127;
        goto L36
    L50:
        r125 = r125;
        goto L53
    L43:
        r246 = false;
        goto L44
    L39:
        r231 = false;
        goto L40
    L5:
        if (r101.moveToFirst() == false) goto L30;
    L6:
        String r249 = r101.getString(r101.getColumnIndex(r108));
        String r250 = r108;
        String r251 = r101.getString(r101.getColumnIndex(r106));
        r211 = r106;
        String r252 = r101.getString(r101.getColumnIndex("size"));
        String r253 = r101.getString(r101.getColumnIndex(r105));
        String r254 = r105;
        String r255 = r101.getString(r101.getColumnIndex("subType"));
        String r256 = r101.getString(r101.getColumnIndex("icon_url"));
        String r257 = r101.getString(r101.getColumnIndex("icon_key"));
        String r258 = r101.getString(r101.getColumnIndex("icon_nonce"));
        int r259 = r101.getInt(r101.getColumnIndex("icon_encrypted_type"));
        if (r101.getInt(r101.getColumnIndex("is_external")) != 1) goto L9;
        boolean r260 = true;
    L10:
        String r261 = r101.getString(r101.getColumnIndex(r104));
        boolean r318 = r260;
        String r262 = r101.getString(r101.getColumnIndex("add_time"));
        String r263 = r101.getString(r101.getColumnIndex(r103));
        String r319 = r104;
        if (r101.getInt(r101.getColumnIndex("copiable")) != 1) goto L13;
        boolean r264 = true;
    L14:
        String r265 = r101.getString(r101.getColumnIndex("owner_id"));
        boolean r320 = r264;
        String r266 = r101.getString(r101.getColumnIndex("create_tenant_id"));
        String r321 = r103;
        String r267 = r101.getString(r101.getColumnIndex("creator_cn_name"));
        String r268 = r101.getString(r101.getColumnIndex("creator_en_name"));
        String r269 = r101.getString(r101.getColumnIndex("open_time"));
        String r270 = r101.getString(r101.getColumnIndex(r112));
        String r271 = r101.getString(r101.getColumnIndex("fake_token"));
        String r417 = r112;
        if (r101.getInt(r101.getColumnIndex(EventConstants.ExtraJson.EXTRA_IS_STAR)) != 1) goto L17;
        boolean r1102 = true;
    L18:
        boolean r418 = r1102;
        if (r101.getInt(r101.getColumnIndex("is_top")) != 1) goto L21;
        boolean r272 = true;
    L22:
        String r1103 = r101.getString(r101.getColumnIndex(r111));
        String r419 = r111;
        String r1104 = r101.getString(r101.getColumnIndex(r107));
        String r420 = r107;
        if (r101.getInt(r101.getColumnIndex("is_need_wifi_download")) != 1) goto L25;
        boolean r273 = true;
    L26:
        String r1105 = r101.getString(r101.getColumnIndex("thumbnail_url"));
        boolean r421 = r273;
        String r274 = r101.getString(r101.getColumnIndex(r102));
        String r275 = r210;
        String r276 = r102;
        String r277 = r101.getString(r101.getColumnIndex(r275));
        String r278 = r116;
        int r279 = r101.getInt(r101.getColumnIndex(r278));
        String r280 = r115;
        String r281 = r101.getString(r101.getColumnIndex(r280));
        String r282 = r114;
        int r283 = r101.getInt(r101.getColumnIndex(r282));
        String r284 = r101.getString(r101.getColumnIndex("document_icon_fsunit"));
        Cursor r514 = r101;
        ContentValues r285 = new ContentValues();
        r285.put(r250, r249);
        r285.put(r211, r251);
        r118 = r254;
        r285.put(r118, r253);
        r285.put("owner_id", r265);
        r285.put("create_tenant_id", r266);
        r285.put("creator_cn_name", r267);
        r285.put("creator_en_name", r268);
        r285.put(r321, r263);
        r285.put(r319, r261);
        r285.put("fake_token", r271);
        r285.put("is_stared", Boolean.valueOf(r418));
        r285.put("is_pined", Boolean.valueOf(r272));
        r285.put("extra_icon_url", r256);
        r285.put("extra_icon_key", r257);
        r285.put("extra_icon_nonce", r258);
        r285.put("extra_icon_encrypted_type", Integer.valueOf(r259));
        r109 = r420;
        r285.put(r109, r1104);
        r285.put("extra_copiable", Boolean.valueOf(r320));
        r285.put("extra_is_external", Boolean.valueOf(r318));
        r285.put("extra_sub_type", r255);
        r120 = r417;
        r285.put(r120, r270);
        r285.put("thumbnail_url", r1105);
        r285.put(r276, r274);
        r285.put(r275, r277);
        r285.put(r278, Integer.valueOf(r279));
        r116 = r278;
        r285.put("size", r252);
        r121 = r113;
        r121.put(r249, r252);
        r285.put(r109, r1104);
        r285.put(r280, r281);
        r285.put(r282, Integer.valueOf(r283));
        r114 = r282;
        r285.put("document_icon_fsunit", r284);
        r123 = r510;
        r210 = r275;
        r115 = r280;
        r119 = r319;
        r123.insert("DocMetaInfo", 5, r285);
        ContentValues r286 = new ContentValues();
        r108 = r250;
        r286.put(r108, r249);
        r286.put("list_type", 7);
        r117 = r419;
        r286.put(r117, r1103);
        r122 = r276;
        r286.put("add_time_manualoffline", r262);
        r286.put("open_time_recent", r269);
        r286.put("is_need_wifi_download", Boolean.valueOf(r421));
        r123.insert("ListTypes", 5, r286);
        if (r514.moveToNext() == false) goto L28;
        r112 = r120;
        r104 = r119;
        r102 = r122;
        r106 = r211;
        r101 = r514;
        r113 = r121;
        r105 = r118;
        r111 = r117;
        r107 = r109;
        r103 = r321;
        goto L6
    L28:
        r124 = r321;
        r101 = r514;
        goto L31
    L25:
        r273 = false;
        goto L26
    L21:
        r272 = false;
        goto L22
    L17:
        r1102 = false;
        goto L18
    L13:
        r264 = false;
        goto L14
    L9:
        r260 = false;
        goto L10
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("DROP TABLE IF EXISTS `ListTypes`");
        r100.execSQL("DROP TABLE IF EXISTS `DocMetaInfo`");
        r100.execSQL("CREATE TABLE IF NOT EXISTS `DocMetaInfo` (`obj_token` TEXT NOT NULL PRIMARY KEY, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT,`creator_cn_name` TEXT,`creator_en_name` TEXT,`edit_uid` TEXT,`edit_time` TEXT,`url` TEXT,`fake_token` TEXT,`is_stared` INTEGER NOT NULL DEFAULT 0,`is_pined` INTEGER NOT NULL DEFAULT 0,`extra_icon_url` TEXT,`extra_icon_key` TEXT,`extra_icon_nonce` TEXT,`extra_icon_encrypted_type` INTEGER NOT NULL DEFAULT 0,`extra_copiable` INTEGER NOT NULL DEFAULT 0,`extra_is_share_root` INTEGER NOT NULL DEFAULT 0,`extra_is_external` INTEGER NOT NULL DEFAULT 0,`extra_sub_type` TEXT,`is_visited` INTEGER NOT NULL DEFAULT 0,`create_time` TEXT,`thumbnail` TEXT,`thumbnail_url` TEXT,`thumbnail_secret` TEXT,`thumbnail_nonce` TEXT,`thumbnail_type` INTEGER NOT NULL DEFAULT 0,`permission` INTEGER NOT NULL DEFAULT 0,`share_time` TEXT,`share_version` INTEGER NOT NULL DEFAULT 0,`is_hidden` INTEGER NOT NULL DEFAULT 0,`need_sync` INTEGER NOT NULL DEFAULT 0,`size` TEXT,`document_icon_key` TEXT,`document_icon_type` INTEGER NOT NULL DEFAULT -1,`document_icon_fsunit` TEXT,`doc_cache_status` INTEGER NOT NULL DEFAULT 0,`is_offline_create` INTEGER NOT NULL DEFAULT 0)");
        r100.execSQL("CREATE INDEX IF NOT EXISTS index_obj_token ON DocMetaInfo(`obj_token`)");
        r100.execSQL("CREATE TABLE IF NOT EXISTS `ListTypes` (`obj_token` TEXT NOT NULL, `list_type` INTEGER NOT NULL DEFAULT 0, `file_path` TEXT NOT NULL DEFAULT '',`token` TEXT, `extra` TEXT, `space_id` TEXT,`add_time_manualoffline` TEXT,`is_need_wifi_download` INTEGER NOT NULL DEFAULT 0,`open_time_recent` TEXT,`my_edit_time_recent` TEXT,`activity_time_recent` TEXT,FOREIGN KEY(`obj_token`) REFERENCES DocMetaInfo(`obj_token`) ON UPDATE CASCADE,PRIMARY KEY(`obj_token`, `list_type`, `file_path`))");
        b(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a.f("Migration40_41", e, false);
    }
}
