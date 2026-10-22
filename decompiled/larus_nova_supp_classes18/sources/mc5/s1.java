package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s1 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET type=?, url=?, icon=? ,is_stared=?,is_pined=?, extra_icon_url=?, extra_icon_key=?, extra_icon_nonce=?,extra_icon_encrypted_type=?, extra_copiable=?, extra_sub_type=?, obj_sub_type=?, document_icon_key=?, document_icon_type=?,document_icon_fsunit=?, app_id=?, wiki_real_type=?,wiki_real_token=?,wiki_version=?,owner_type =?,template_type =?, is_insert =?, organization_tag_value=?, file_risk_tag=?, is_wiki_home_page =? WHERE obj_token = ?";
    }

    public s1(BearDatabase r1) {
        super(r1);
    }
}
