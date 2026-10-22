package rr4;

import com.bytedance.ee.bear.bitable.common.widgets.item.extend.userlist.UserListData;
import com.bytedance.ee.bear.bitable.common.widgets.item.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements m {
    public c() {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.m
    public final UserListData a(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        UserListData r101 = new UserListData();
        Type r102 = new b().getType();
        r101.setUserList((ArrayList) GsonProtectorUtils.fromJson(new Gson(), r100, r102));
        return r101;
    }
}
