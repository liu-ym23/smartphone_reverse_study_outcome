package ty7;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.card.component.avatar.UniversalCardLynxAvatarUI;
import com.larksuite.component.card.component.checkbox.UniversalCardLynxCheckBoxUI;
import com.larksuite.component.card.component.header.UniversalCardHeaderBgUI;
import com.larksuite.component.card.component.image.UniversalCardLynxImageUI;
import com.larksuite.component.card.component.lottie.LottieUI;
import com.larksuite.component.card.component.personlist.PersonListLynxUI;
import com.larksuite.component.card.component.personlist.avatar.PersonAvatarGroupLynxUI;
import com.larksuite.component.card.component.personlist.avatar.d;
import com.larksuite.component.card.component.personlist.c;
import com.larksuite.component.card.component.slider.UniversalCardLynxSliderUI;
import com.larksuite.component.card.component.table.TableMarkdownUI;
import com.larksuite.component.card.component.text.UniversalCardTextLynxUI;
import com.larksuite.component.card.component.text.g;
import com.larksuite.component.card.component.udicon.UniversalCardUDIconUI;
import com.larksuite.component.card.debugger.ICardDebugger;
import com.larksuite.component.card.plugin.CardDigestPlugin;
import com.larksuite.component.card.plugin.CardGetHostInfoPlugin;
import com.larksuite.component.card.plugin.CardOpenUrlPlugin;
import com.larksuite.component.card.plugin.CardUpdateLocalDataPlugin;
import com.larksuite.component.card.plugin.FetchCardPlugin;
import com.larksuite.component.card.plugin.GetAppSettingsPlugin;
import com.larksuite.component.card.plugin.MsgCardShowOverflowPlugin;
import com.larksuite.component.card.plugin.OPPlugin;
import com.larksuite.component.card.plugin.OnSubmitInputPlugin;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larksuite.component.card.plugin.SendClientMessagePlugin;
import com.larksuite.component.card.plugin.SendRequestPlugin;
import com.larksuite.component.card.plugin.ShowCardChartPlugin;
import com.larksuite.component.card.plugin.ShowCardToastPlugin;
import com.larksuite.component.card.plugin.ShowConfirmPlugin;
import com.larksuite.component.card.plugin.ShowDatePickerPlugin;
import com.larksuite.component.card.plugin.ShowProfilePlugin;
import com.larksuite.component.card.plugin.ShowSelectMenuPlugin;
import com.larksuite.component.card.plugin.ShowTableDetailPlugin;
import com.larksuite.component.card.plugin.UpdateStreamingStatePlugin;
import com.larksuite.component.card.plugin.audio.CardGetAudioStatePlugin;
import com.larksuite.component.card.plugin.audio.CardOperateAudioPlugin;
import com.larksuite.component.card.plugin.video.CardPreviewVideoPlugin;
import com.larksuite.component.card.utils.k;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.utils.LarkContext;
import idb.f;
import java.util.ArrayList;
import java.util.Iterator;
import l18.h;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile yy7.a f547990a;

    /* JADX INFO: renamed from: ty7.a$a, reason: collision with other inner class name */
    public class C7804a implements com.ss.android.lark.lynxkit.initializer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f547991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f547992b;

        @Override // com.ss.android.lark.lynxkit.initializer.a
        public final LynxGroup a() {
            if (this.f547991a == false) goto L5;
            LynxEnv.inst().tryToLoadV8Bridge(false);
        L5:
            String r100 = LynxGroup.SINGNLE_GROUP;
            return LynxGroup.Create(r100, r100, null, false, this.f547992b, this.f547991a);
        }

        public C7804a(boolean r100, boolean r101) {
            this.f547991a = r100;
            this.f547992b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f547993a = null;

        static {
            f547993a = new a();
        }
    }

    public static yy7.a a() {
        a r100 = b.f547993a;
        if (f547990a != null) goto L14;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (f547990a != null) goto L8;
        f547990a = (yy7.a) ClaymoreServiceLoader.loadFirst(yy7.a.class);     // Catch: Throwable -> L10
        LarkLynxKitInitializer.Companion.getClass();     // Catch: Throwable -> L10
        LarkLynxKitInitializer r101 = LarkLynxKitInitializer.b.a();     // Catch: Throwable -> L10
        LarkContext.getApplication();     // Catch: Throwable -> L10
        r101.registerCustomComponents("UniversalCard", b());     // Catch: Throwable -> L10
        c();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
    L14:
        return f547990a;
    }

    public static ArrayList b() {
        ArrayList r100 = new ArrayList();
        int r101 = UniversalCardLynxImageUI.f283381f;
        r100.add(new com.larksuite.component.card.component.image.b());
        int r102 = UniversalCardTextLynxUI.f283581g;
        r100.add(new g());
        int r103 = UniversalCardHeaderBgUI.f283374a;
        r100.add(new com.larksuite.component.card.component.header.a());
        int r104 = UniversalCardUDIconUI.f283682d;
        r100.add(new com.larksuite.component.card.component.udicon.a());
        int r105 = PersonListLynxUI.f283418a;
        r100.add(new c());
        int r106 = PersonAvatarGroupLynxUI.f283430a;
        r100.add(new d());
        int r107 = UniversalCardLynxAvatarUI.f283303b;
        r100.add(new com.larksuite.component.card.component.avatar.a());
        int r108 = UniversalCardLynxCheckBoxUI.f283362c;
        r100.add(new com.larksuite.component.card.component.checkbox.b());
        int r109 = TableMarkdownUI.f283574d;
        r100.add(new com.larksuite.component.card.component.table.a());
        int r110 = LottieUI.f283416a;
        r100.add(new com.larksuite.component.card.component.lottie.a());
        int r111 = xy7.b.f565411a;
        r100.add(new xy7.a());
        int r112 = xy7.d.f565412a;
        r100.add(new xy7.c());
        int r113 = UniversalCardLynxSliderUI.f283560a;
        r100.add(new com.larksuite.component.card.component.slider.b());
        int r114 = com.larksuite.component.card.debugger.b.f283715a;
        ICardDebugger.f283712a.getClass();
        r100.addAll(ICardDebugger.Companion.f283714b.getValue().b());
        return r100;
    }

    public static void c() {
        Context r100 = f547990a.getContext();
        if (r100 != null) goto L5;
        r100 = com.larksuite.framework.utils.b.f285948a.getApplicationContext();
    L5:
        jz7.b r101 = new jz7.b(r100);
        h r102 = r101.f507012a;
        r102.b(new ShowCardToastPlugin());
        r102.b(new CardDigestPlugin());
        r102.b(new CardUpdateLocalDataPlugin());
        r102.b(new CardOpenUrlPlugin());
        r102.b(new MsgCardShowOverflowPlugin());
        r102.b(new OnSubmitInputPlugin());
        r102.b(new ShowDatePickerPlugin());
        r102.b(new ShowSelectMenuPlugin());
        r102.b(new ShowConfirmPlugin());
        r102.b(new SendRequestPlugin());
        r102.b(new SendClientMessagePlugin());
        r102.b(new ReportCardMonitorPlugin());
        r102.b(new ShowCardChartPlugin());
        r102.b(new ShowTableDetailPlugin());
        r102.b(new ShowProfilePlugin());
        r102.b(new UpdateStreamingStatePlugin());
        r102.b(new FetchCardPlugin());
        r102.b(new GetAppSettingsPlugin());
        r102.b(new CardGetHostInfoPlugin());
        r102.b(new CardOperateAudioPlugin());
        r102.b(new CardGetAudioStatePlugin());
        r102.b(new CardPreviewVideoPlugin());
        int r103 = com.larksuite.component.card.debugger.b.f283715a;
        ICardDebugger.f283712a.getClass();
        Iterator<OPPlugin> r104 = ICardDebugger.Companion.f283714b.getValue().a().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r102.b(r104.next());
        goto L7
    L9:
        uy7.a r105 = new uy7.a(r100, r102);
        r105.f557530q = r101;
        ayb.a r106 = new ayb.a(r105);
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer.b.a().registerBridgeMethodDispatcher("UniversalCard", r106);
        boolean r107 = f.a().isEnable("openplatform.universalcard.v8_engine");
        boolean r108 = k.a(r100);
        LarkLynxKitInitializer.b.a().registerLynxGroup("UniversalCard", new C7804a(r107, r108));
    }

    public a() {
    }
}
