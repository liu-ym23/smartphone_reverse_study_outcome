package p1c;

import android.content.Context;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileNavigator$openChat$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    Map<String, RecogniseSpansResult> a(List<UrlPreViewEntries> r100, String r101, String r102, Long r103);

    void b(Context r100, String r101, OfficeProfileNavigator$openChat$1 r102);

    void c(String r100, String r101, Long r102, OfficeProfileViewModel.C121052 r103);
}
