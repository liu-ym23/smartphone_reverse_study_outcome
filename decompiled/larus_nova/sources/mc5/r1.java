package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class r1 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET name = ?, type=?,icon =?, owner_id = ?,create_tenant_id=?, creator_cn_name=?, creator_en_name=?, edit_uid=?,edit_time=?, url=?, fake_token=?, is_stared=?,is_pined=?, extra_icon_url=?, extra_icon_key=?, extra_icon_nonce=?,extra_icon_encrypted_type=?, extra_copiable=?, extra_is_share_root=?, extra_is_external=?,extra_sub_type=?, obj_sub_type=?, is_visited=?, create_time=?, thumbnail_url=?,thumbnail_secret=?, thumbnail_nonce=?, thumbnail_type=?, permission=?,share_version=?, need_sync=?,thumbnail=?, document_icon_key=?, document_icon_type=?,document_icon_fsunit=?, app_id=?, wiki_real_type=?, wiki_real_token=?, wiki_version=?,is_subscribed=?,owner_type =?, is_offline_create = ?, is_share_folder=?, security_name=?, security_level =?,is_secret_key_delete =?, template_type =?, is_insert =?, organization_tag_value =?, file_risk_tag =?, is_wiki_home_page =? WHERE obj_token = ?";
    }

    public r1(BearDatabase r100) {
        super(r100);
    }
}
