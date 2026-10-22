package w4b;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface b0 {
    void a(Context r100, String r101, String r102);

    void b(Context r100, y6b.b r101, Chat r102);

    void c(Context r100, Bundle r101);

    void e(Context r100, ProfileSource r101);

    ArrayList<BaseField> parseFields(List<GetUserProfileResponse.Field> r100);
}
