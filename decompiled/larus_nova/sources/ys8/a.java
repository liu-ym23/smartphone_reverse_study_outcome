package ys8;

import android.content.Intent;
import android.net.Uri;
import com.larus.bmhome.actionbar.model.e2;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.w0;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.actionbar.edit.o;
import com.larus.bmhome.view.actionbar.edit.p;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
public interface a extends t1a.a {
    void A1();

    void A8(String r100);

    boolean A80();

    void GX(int r100, long r101);

    void Gk(TemplateInfo$TemplateInfo r100, Uri r101);

    String J6();

    void JI();

    int M4();

    void M70();

    String O3(int r100);

    boolean P0();

    boolean Pz();

    int Q1();

    int S4();

    void S7();

    NestedFileContent T();

    void T1();

    NestedFileContent Wd();

    boolean Wm();

    int X1();

    b Xx(long r100);

    void b00(int r100);

    String c0();

    void c00(int r100);

    void c6();

    boolean dk(int r100);

    List<w> getCurImageList();

    r getCurrentInstructionConf();

    Long getDefaultSelectedImageStyleId();

    List<w> getRatioOptionList();

    d1<o> getSelectDurationFlow();

    i1<p> getSelectVideoModelFlow();

    void h60();

    boolean i3();

    boolean isInVideoTab();

    String k();

    boolean lv();

    void mI(Intent r100);

    ArrayList<Integer> mr();

    AttachmentInfo n4();

    void onDigitalAvatarTemplateChoose(ab8.a r100, int r101, String r102);

    boolean pE();

    void pV();

    void pz(int r100, Intent r101);

    boolean qo();

    void refreshImageListSelectorWithMore(List<w> r100);

    void selectRatio(int r100, long r101);

    void selectRatio(long r100);

    void setEnableResetTemplateCacheAfterDetach(boolean r100);

    void setOriginalRatioEnable(boolean r100);

    void setRatioDropDownSelectorClickInterceptor(Function0<Boolean> r100);

    void setVideoModelDropDownSelectorClickInterceptor(Function0<Boolean> r100);

    b1 tP();

    e2 tQ();

    boolean w4();

    void wr(boolean r100);

    boolean x(String r100);

    String xh();

    String y6(String r100);

    String y60(String r100, boolean r101);

    w0 yn();

    boolean z0();

    String zQ();
}
