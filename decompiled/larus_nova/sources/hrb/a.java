package hrb;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: hrb.a$a, reason: collision with other inner class name */
    public interface InterfaceC6188a {
    }

    public interface b {
    }

    RichTextElement.AtProperty getAtProperty(com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty r100) throws Exception;

    int getChatThreadLynxCardMessageWidth(Integer r100);

    Context getContext();

    String getDynamicDomain(String r100);

    boolean getFgValue(String r100);

    boolean getFgValue(String r100, boolean r101);

    RichTextElement.ImageProperty getImageProperty(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r100) throws Exception;

    Locale getLanguageSetting();

    String getLoginTenantId();

    String getLoginUserId();

    int getLynxCardMessageWidth(boolean r100, Integer r101);

    int getMaxMessageWidth(int r100);

    int getThreadDetailLynxCardMessageWidth(boolean r100, Integer r101);

    int getThreadLynxCardMessageWidth(boolean r100, Integer r101);

    boolean is12HourClock();

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void openUrl(Context r100, String r101, boolean r102, boolean r103, Boolean r104, String r105);

    RichText parsePbFromRichText(com.ss.android.lark.widget.richtext.RichText r100);

    com.ss.android.lark.widget.richtext.RichText parseRichTextFromPb(RichText r100);

    com.ss.android.lark.widget.richtext.RichText parseRichTextFromPbWithStyleMerge(RichText r100, HashMap r101);

    void pickGroupMember(Activity r100, String r101, List<String> r102, boolean r103, String r104, IGetDataCallback<List<ChatChatter>> r105);

    void pickTargetMember(Activity r100, List<String> r101, List<String> r102, boolean r103, String r104, IGetDataCallback<List<ChatChatter>> r105);

    void setBgForCustomHeader(View r100, View r101, int[] r102);
}
