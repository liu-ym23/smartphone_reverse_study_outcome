package yya;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a implements m2b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f569504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<MessageActionType, ? extends List<? extends i>> f569505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f569506c;

    /* JADX INFO: renamed from: yya.a$a, reason: collision with other inner class name */
    public static final class C8405a {
    }

    static {
    }

    public boolean Y() {
        return false;
    }

    public abstract Fragment d();

    public abstract Message g();

    public abstract FragmentActivity getActivity();

    public abstract Chat getChat();

    public abstract Context getContext();

    public <T extends mya.g> T j(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        return null;
    }

    public abstract p5b.c k();

    public abstract v5b.c<?> m();

    public abstract Chatter q();

    public abstract PageType r();

    public abstract Chatter u();

    public Message.Type l() {
        return m().getType();
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f569504a = r100;
        new LinkedHashMap();
    }
}
