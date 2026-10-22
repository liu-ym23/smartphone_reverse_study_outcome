package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.check.CheckResult;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.CheckConfirmValue;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.ExtendFieldOptions;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.FieldCommandFailReason;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.FieldCommandResult;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.FieldCommandResultCode;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.FieldExtendBean;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.EExtendInfo;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendConfigs;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendFieldBaseInfo;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.extendfield.ExtendFieldPropertyEditView;
import com.bytedance.ee.bear.bitable.fieldedit.view.selection.BitableFieldTypeSelectionFragment;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.FieldEditText;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.widget.KeyboardPlaceholderView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.edittext.UDTextInputLayout;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ä\u00012\u00020\u00012\u00020\u0002:\u0004ä\u0001å\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010e\u001a\u00020fH\u0002J.\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\t\u0010\u0097\u0001\u001a\u00020fH\u0016J\u001f\u0010\u0098\u0001\u001a\u00020f2\b\u0010\u0099\u0001\u001a\u00030\u008f\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\t\u0010\u009a\u0001\u001a\u00020fH\u0002J\t\u0010\u009b\u0001\u001a\u00020fH\u0002J\t\u0010\u009c\u0001\u001a\u00020fH\u0002J\t\u0010\u009d\u0001\u001a\u00020fH\u0002J\t\u0010\u009e\u0001\u001a\u00020fH\u0002J\t\u0010\u009f\u0001\u001a\u00020fH\u0002JD\u0010 \u0001\u001a\u00020n2\b\u0010¡\u0001\u001a\u00030¢\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u00012\u0011\u0010§\u0001\u001a\f\u0012\u0005\u0012\u00030©\u0001\u0018\u00010¨\u0001H\u0002¢\u0006\u0003\u0010ª\u0001J\u0015\u0010«\u0001\u001a\u00020f2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0002J\u0017\u0010\u00ad\u0001\u001a\u00020f2\f\b\u0002\u0010¬\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0002J\"\u0010®\u0001\u001a\u00030¯\u00012\b\u0010°\u0001\u001a\u00030\u0087\u00012\f\b\u0002\u0010±\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0002J\t\u0010²\u0001\u001a\u00020fH\u0003J\u0012\u0010³\u0001\u001a\u000b\u0012\u0004\u0012\u00020w\u0018\u00010´\u0001H\u0002JV\u0010µ\u0001\u001a\u00020f2\b\u0010¶\u0001\u001a\u00030\u0085\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\u000b\b\u0002\u0010¿\u0001\u001a\u0004\u0018\u00010wH\u0002¢\u0006\u0003\u0010À\u0001JC\u0010Á\u0001\u001a\u00020f2\b\u0010¶\u0001\u001a\u00030\u0085\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0002JO\u0010Â\u0001\u001a\u00020f2\b\u0010¶\u0001\u001a\u00030\u0085\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0002Jd\u0010Å\u0001\u001a\u00020f2\b\u0010¶\u0001\u001a\u00030\u0085\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\f\b\u0002\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u00012\u000b\b\u0002\u0010¿\u0001\u001a\u0004\u0018\u00010wH\u0002¢\u0006\u0003\u0010È\u0001J\u0015\u0010É\u0001\u001a\u00020f2\n\u0010Ê\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002J\u001e\u0010Ë\u0001\u001a\u00020f2\u0007\u0010Ì\u0001\u001a\u00020w2\n\b\u0002\u0010Í\u0001\u001a\u00030\u0087\u0001H\u0002J\t\u0010Î\u0001\u001a\u00020fH\u0002J\t\u0010Ï\u0001\u001a\u00020fH\u0002J\t\u0010Ð\u0001\u001a\u00020fH\u0002J\u0013\u0010Ñ\u0001\u001a\u00020f2\b\u0010Ò\u0001\u001a\u00030¢\u0001H\u0002J\u0015\u0010Ó\u0001\u001a\u00020f2\n\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001H\u0002J'\u0010Ö\u0001\u001a\u00030×\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u00012\u0007\u0010Ú\u0001\u001a\u00020w2\b\u0010Û\u0001\u001a\u00030Ù\u0001H\u0016J\u0013\u0010Ü\u0001\u001a\u00020f2\b\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0016J\t\u0010ß\u0001\u001a\u00020wH\u0016J\t\u0010à\u0001\u001a\u00020wH\u0002J\t\u0010á\u0001\u001a\u00020wH\u0002J\t\u0010â\u0001\u001a\u00020fH\u0002J\t\u0010ã\u0001\u001a\u00020fH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u0004\u0018\u00010!8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010'8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001e\u0010/\u001a\u0004\u0018\u0001008FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0004\u0018\u0001068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u0004\u0018\u0001068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u001e\u0010>\u001a\u0004\u0018\u00010?8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0014\"\u0004\bF\u0010\u0016R\u001e\u0010G\u001a\u0004\u0018\u00010H8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u0010M\u001a\u0004\u0018\u00010N8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010S\u001a\u0004\u0018\u00010T8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u0004\u0018\u00010Z8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010_\u001a\u0004\u0018\u00010`8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001b\u0010g\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bi\u0010jR\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010o\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010l\u001a\u0004\bq\u0010rR\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020wX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010x\u001a\u0004\u0018\u00010y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010l\u001a\u0004\bz\u0010{R\u001d\u0010}\u001a\u0011\u0012\u0004\u0012\u00020\u007f\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010~X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008a\u0001\u001a\u00030\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u008c\u0001\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u008d\u0001R\u0012\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006æ\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BitableFieldEditFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "fieldNameETFromXml", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/FieldEditText;", "getFieldNameETFromXml", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/FieldEditText;", "setFieldNameETFromXml", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/FieldEditText;)V", "fieldBaseMetaContainerFromXml", "Landroid/widget/LinearLayout;", "getFieldBaseMetaContainerFromXml", "()Landroid/widget/LinearLayout;", "setFieldBaseMetaContainerFromXml", "(Landroid/widget/LinearLayout;)V", "aiConfigLayoutFromXml", "getAiConfigLayoutFromXml", "setAiConfigLayoutFromXml", "fieldShortcutContainerFromXml", "getFieldShortcutContainerFromXml", "setFieldShortcutContainerFromXml", "fieldTypeSelectorFromXml", "getFieldTypeSelectorFromXml", "setFieldTypeSelectorFromXml", "fieldRightIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getFieldRightIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setFieldRightIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "noticeFromXml", "Lcom/larksuite/component/universe_design/notice/UDNotice;", "getNoticeFromXml", "()Lcom/larksuite/component/universe_design/notice/UDNotice;", "setNoticeFromXml", "(Lcom/larksuite/component/universe_design/notice/UDNotice;)V", "fieldTypeSelectorWrapperFromXml", "getFieldTypeSelectorWrapperFromXml", "setFieldTypeSelectorWrapperFromXml", "fieldTypeIVFromXml", "Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "getFieldTypeIVFromXml", "()Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;", "setFieldTypeIVFromXml", "(Lcom/bytedance/ee/bear/bitable/common/widgets/SyncIconImageView;)V", "fieldTypeTVFromXml", "Landroid/widget/TextView;", "getFieldTypeTVFromXml", "()Landroid/widget/TextView;", "setFieldTypeTVFromXml", "(Landroid/widget/TextView;)V", "shortcutNameFromXml", "getShortcutNameFromXml", "setShortcutNameFromXml", "shortcutLogoFromXml", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getShortcutLogoFromXml", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "setShortcutLogoFromXml", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;)V", "fieldPropertyWrapperFromXml", "getFieldPropertyWrapperFromXml", "setFieldPropertyWrapperFromXml", "keyboardPlaceholderFromXml", "Lcom/bytedance/ee/bear/document/widget/KeyboardPlaceholderView;", "getKeyboardPlaceholderFromXml", "()Lcom/bytedance/ee/bear/document/widget/KeyboardPlaceholderView;", "setKeyboardPlaceholderFromXml", "(Lcom/bytedance/ee/bear/document/widget/KeyboardPlaceholderView;)V", "scrollViewFromXml", "Landroidx/core/widget/NestedScrollView;", "getScrollViewFromXml", "()Landroidx/core/widget/NestedScrollView;", "setScrollViewFromXml", "(Landroidx/core/widget/NestedScrollView;)V", "fieldPropertyExtendContainerFromXml", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldPropertyEditView;", "getFieldPropertyExtendContainerFromXml", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldPropertyEditView;", "setFieldPropertyExtendContainerFromXml", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldPropertyEditView;)V", "fieldPropertyEditContainerFromXml", "Landroid/widget/FrameLayout;", "getFieldPropertyEditContainerFromXml", "()Landroid/widget/FrameLayout;", "setFieldPropertyEditContainerFromXml", "(Landroid/widget/FrameLayout;)V", "fieldNameErrorBgFromXml", "Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "getFieldNameErrorBgFromXml", "()Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "setFieldNameErrorBgFromXml", "(Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;)V", "clearFromXmlViewCache", "", "mFieldEditViewModel", "Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "getMFieldEditViewModel", "()Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "mFieldEditViewModel$delegate", "Lkotlin/Lazy;", "mCurrentFieldPropertyEditViewHolder", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/IFieldPropertyEditViewHolder;", "mStatusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "getMStatusBar", "()Lcom/bytedance/ee/util/statusbar/IStatusBar;", "mStatusBar$delegate", "mSaveMenuAction", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar$TextAction;", "mIsFieldNameValid", "", "mBitableAnalytic", "Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "getMBitableAnalytic", "()Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "mBitableAnalytic$delegate", "mDisposableMap", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BitableFieldEditFragment$FieldEditFragmentDisposeName;", "Lio/reactivex/disposables/Disposable;", "mIsFieldPropertyValid", "switchSelectFieldTime", "", "mPreFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "mSceneType", "", "mActionType", "mOriginFieldCompositeType", "mFieldEditShowStartTime", "mHasEditFieldSubSetting", "mSubSettingCheckBoxValue", "Ljava/lang/Boolean;", "mFieldEditRootContainer", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "onViewCreated", "view", "initView", "initFieldAIConfigView", "initShortcutView", "initNoticeView", "updateViewFieldTypeSelector", "initDataObserver", "onCreateFieldPropertyEditViewHolder", "editFieldInfo", "Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel$EditFieldInfo;", "panelData", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData;", "fieldConfigMeta", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel;", "commonColorList", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "(Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel$EditFieldInfo;Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData;Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel;[Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;)Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/IFieldPropertyEditViewHolder;", "createFieldTypeSelectionFragment", "args", "createFieldPropertySelectionFragment", "createChildFragment", "Landroidx/fragment/app/Fragment;", "fragmentClassName", "bundle", "onSaveBtnClicked", "beforeSaveClick", "Lio/reactivex/Observable;", "checkIfNeedConfirmBeforeSave", "fieldCompositeType", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "extendFieldOptions", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;", "fieldExtendBean", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;", "generateAIContent", "(Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;Ljava/lang/Boolean;)V", "confirmConvertPeople", "confirmExtendFieldDelete", "extra", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/check/ConfirmExtendFieldDeleteExtra;", "saveFieldEditData", "checkConfirmValue", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;", "(Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldExtendBean;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/CheckConfirmValue;Ljava/lang/Boolean;)V", "checkFieldNameValidity", "fieldName", "notifyFieldNameValidityChanged", "isFieldNameValid", "errorText", "updateSaveMenuState", "reportFieldModifyPanelDuration", "triggerExitEventManually", "notifyFieldExtendEditViewFieldEditInfoChanged", "fieldEditInfo", "updateFieldExtendEditView", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendConfigs;", "onCreateAnimation", "Landroid/view/animation/Animation;", AppletNaviType.TRANSIT, "", "enter", "nextAnim", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "showShortcut", "hideAiConfigLayout", "exitFragment", "onDestroyView", "Companion", "FieldEditFragmentDisposeName", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFieldEditFragment extends BaseFragment implements com.bytedance.ee.bear.l {
    public static final Integer O = null;
    public BaseTitleBar.e A;
    public boolean B;
    public final Lazy C;
    public final Map<FieldEditFragmentDisposeName, Disposable> D;
    public boolean E;
    public long F;
    public FieldCompositeType G;
    public String H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public FieldCompositeType f211162J;
    public long K;
    public boolean L;
    public Boolean M;
    public View N;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f211163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FieldEditText f211164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f211165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f211166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f211167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f211168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AppCompatImageView f211169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UDNotice f211170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f211171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SyncIconImageView f211172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f211173o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f211174p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LKUIRoundedImageView2 f211175q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LinearLayout f211176r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public KeyboardPlaceholderView f211177s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public NestedScrollView f211178t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ExtendFieldPropertyEditView f211179u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f211180v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public UDTextInputLayout f211181w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f211182x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q0 f211183y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f211184z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BitableFieldEditFragment$FieldEditFragmentDisposeName;", "", "<init>", "(Ljava/lang/String;I)V", "Save", "FetchFieldConfig", "ReportFieldModifyClick", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FieldEditFragmentDisposeName extends Enum<FieldEditFragmentDisposeName> {
        public static final FieldEditFragmentDisposeName FetchFieldConfig = null;
        public static final FieldEditFragmentDisposeName ReportFieldModifyClick = null;
        public static final FieldEditFragmentDisposeName Save = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FieldEditFragmentDisposeName[] f211185a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211186b = null;

        public static EnumEntries<FieldEditFragmentDisposeName> getEntries() {
            return f211186b;
        }

        static {
            FieldEditFragmentDisposeName r100 = new FieldEditFragmentDisposeName("Save", 0);
            Save = r100;
            FieldEditFragmentDisposeName r101 = new FieldEditFragmentDisposeName("FetchFieldConfig", 1);
            FetchFieldConfig = r101;
            FieldEditFragmentDisposeName r102 = new FieldEditFragmentDisposeName("ReportFieldModifyClick", 2);
            ReportFieldModifyClick = r102;
            FieldEditFragmentDisposeName[] r103 = {r100, r101, r102};
            f211185a = r103;
            f211186b = EnumEntriesKt.enumEntries(r103);
        }

        public static FieldEditFragmentDisposeName[] values() {
            return (FieldEditFragmentDisposeName[]) f211185a.clone();
        }

        public static FieldEditFragmentDisposeName valueOf(String r100) {
            return (FieldEditFragmentDisposeName) r27.a.a(FieldEditFragmentDisposeName.class, r100);
        }

        public FieldEditFragmentDisposeName(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211187a = null;

        static {
            int[] r100 = new int[FieldEditPanelData.EEditNotice.values().length];
            r100[FieldEditPanelData.EEditNotice.EXTEND_FIELD_OWNER_CHANGED_OWNER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[FieldEditPanelData.EEditNotice.EXTEND_FIELD_OWNER_CHANGED_OTHER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[FieldEditPanelData.EEditNotice.EXTEND_FIELD_ORIGIN_DELETE_OWNER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[FieldEditPanelData.EEditNotice.EXTEND_FIELD_ORIGIN_DELETE_OTHER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[FieldEditPanelData.EEditNotice.EXTEND_FIELD_ORIGIN_MULTIPLE_ENABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f211187a = r100;
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f211188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211189b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            if (this.f211188a == false) goto L6;
            BitableFieldEditFragment r101 = this.f211189b;
            Integer r102 = BitableFieldEditFragment.O;
            ((xu5.a) r101.f211184z.getValue()).b(this.f211189b.getResources().getColor(R.color.bg_float_base), !ColorUtils.b(this.f211189b.requireContext()));
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            if (this.f211188a == true) goto L6;
            BitableFieldEditFragment r101 = this.f211189b;
            Integer r102 = BitableFieldEditFragment.O;
            ((xu5.a) r101.f211184z.getValue()).resetState();
            return;
        }

        public c(boolean r100, BitableFieldEditFragment r101) {
            this.f211188a = r100;
            this.f211189b = r101;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211190a;

        public d(BitableFieldEditFragment r100) {
            this.f211190a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            FieldCommandResult r101 = (FieldCommandResult) r100;
            FieldCommandResultCode.a r102 = FieldCommandResultCode.Companion;
            Integer r103 = r101.getResult();
            if (r103 == null) goto L5;
            int r104 = r103.intValue();
        L6:
            r102.getClass();
            FieldCommandResultCode r105 = FieldCommandResultCode.a.a(r104);
            tt5.a.h("BitableFieldEditFragment", "saveFieldEditData result = " + r105);
            if (r105 != FieldCommandResultCode.FAIL) goto L15;
            Integer r106 = r101.getReason();
            int r107 = FieldCommandFailReason.NameRepeat.getValue();
            if (r106 != null) goto L12;
            return;
        L12:
            if (r106.intValue() != r107) goto L18;
            BitableFieldEditFragment r108 = this.f211190a;
            String r109 = r108.getString(R.string.Bitable_Field_NameExists);
            Integer r110 = BitableFieldEditFragment.O;
            r108.fa0(false, r109);
            return;
        L18:
            return;
        L15:
            if (r105 == FieldCommandResultCode.NO_ACTION) goto L20;
            BitableFieldEditFragment r111 = this.f211190a;
            Integer r112 = BitableFieldEditFragment.O;
            r111.W90();
            return;
        L20:
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211191a;

        public e(BitableFieldEditFragment r100) {
            this.f211191a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("BitableFieldEditFragment", "saveFieldEditData failed, " + ((Throwable) r100));
            BitableFieldEditFragment r101 = this.f211191a;
            Integer r102 = BitableFieldEditFragment.O;
            r101.W90();
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211192a;

        public f(BitableFieldEditFragment r100) {
            this.f211192a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BitableFieldEditFragment r101 = this.f211192a;
            Integer r102 = BitableFieldEditFragment.O;
            r101.W90();
            BitableFieldEditAnalytic r103 = this.f211192a.ca0();
            if (r103 == null) goto L6;
            r103.P(false);
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211193a;

        public g(BitableFieldEditFragment r100) {
            this.f211193a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BitableFieldEditFragment r101 = this.f211193a;
            Integer r102 = BitableFieldEditFragment.O;
            BitableFieldEditAnalytic r103 = r101.ca0();
            if (r103 == null) goto L6;
            r103.P(true);
            return;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211194a;

        public h(BitableFieldEditFragment r100) {
            this.f211194a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Toast.showFailureText(this.f211194a.getContext(), R.string.Bitable_Field_PleaseModifyOnDesktop);
        }
    }

    public static final class i extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f211195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211196d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f211195c == true) goto L6;
            Toast.showText(this.f211196d.getContext(), R.string.Bitable_PeopleField_OnlyOwnerCanModifySettings_Description);
            return;
        }

        public i(boolean r100, BitableFieldEditFragment r101) {
            this.f211195c = r100;
            this.f211196d = r101;
        }
    }

    public static final class j extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableFieldEditFragment f211197c;

        public j(BitableFieldEditFragment r100) {
            this.f211197c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Bundle r101 = new Bundle();
            String r102 = "new_field";
            if (TextUtils.equals("new_field", this.f211197c.I) == true) goto L6;
            r102 = "switch";
        L6:
            r101.putString("key_edit_type", r102);
            r101.putString("key_scene_type", BitableFieldEditAnalytic.FieldEditScene.INSERT_FIELD_FROM_GRID_BOARD);
            FieldCompositeType r103 = this.f211197c.f211162J;
            if (r103 == null) goto L9;
            String r104 = r103.getReportValue();
        L10:
            r101.putString("key_from_field_type", r104);
            BitableFieldEditFragment r105 = this.f211197c;
            r105.getClass();
            r105.V90(BitableFieldTypeSelectionFragment.class.getName(), r101);
            BitableFieldEditAnalytic r106 = this.f211197c.ca0();
            if (r106 == null) goto L14;
            BitableFieldEditFragment r107 = this.f211197c;
            r106.R("field_type", BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_TYPE_MODIFY_VIEW, r107.I, r107.H);
            return;
        L14:
            return;
        L9:
            r104 = null;
            goto L10
        }
    }

    static {
        O = (Integer) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("ccm_bitable_field_name_max_length", 100);
    }

    public final LinearLayout X90() {
        View r100 = this.f211166h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.aiConfigLayout);
    L8:
        this.f211166h = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final FieldEditText Y90() {
        View r100 = this.f211164f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.fieldNameET);
    L8:
        this.f211164f = (FieldEditText) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (FieldEditText) r100;
    }

    public final ExtendFieldPropertyEditView Z90() {
        View r100 = this.f211179u;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.fieldPropertyExtendContainer);
    L8:
        this.f211179u = (ExtendFieldPropertyEditView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (ExtendFieldPropertyEditView) r100;
    }

    public final LinearLayout aa0() {
        View r100 = this.f211168j;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.fieldTypeSelector);
    L8:
        this.f211168j = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final TextView ba0() {
        View r100 = this.f211173o;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.fieldTypeTV);
    L8:
        this.f211173o = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    public final BitableFieldEditAnalytic ca0() {
        return (BitableFieldEditAnalytic) this.C.getValue();
    }

    public final BitableFieldEditViewModel da0() {
        return (BitableFieldEditViewModel) this.f211182x.getValue();
    }

    public final boolean ja0() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.base.fields_shortcut.enable") == false) goto L18;
        FieldEditPanelData r101 = da0().getPanelData().getValue();
        if (r101 == null) goto L14;
        String r102 = r101.getExtensionId();
        if (r102 == null) goto L14;
        if (r102.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 != true) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L19;
        return true;
    L19:
        return false;
    L11:
        r103 = false;
    L14:
        r104 = false;
        goto L15
    L18:
        return false;
    }

    public final void la0() {
        if (this.B == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        View r101 = this.f211163e;
        TextView r102 = null;
        if (r101 != null) goto L15;
        View r103 = getView();
        if (r103 == null) goto L13;
        r101 = r103.findViewById(R.id.titleBar);
    L14:
        this.f211163e = (BaseTitleBar) r101;
        goto L15
    L13:
        r101 = null;
    L15:
        BaseTitleBar r104 = (BaseTitleBar) r101;
        BaseTitleBar.e r105 = this.A;
        if (r105 == null) goto L18;
        String r106 = r105.getId();
    L19:
        View r107 = r104.d(r106);
        if ((r107 instanceof TextView) == false) goto L22;
        r102 = (TextView) r107;
    L22:
        if (r102 == null) goto L28;
        if (r100 == false) goto L25;
        int r108 = R.color.primary_fill_default;
    L26:
        r102.setTextColor(getResources().getColor(r108));
        return;
    L25:
        r108 = R.color.text_disable;
        goto L26
    L28:
        return;
    L18:
        r106 = null;
        goto L19
    L5:
        if (this.E == false) goto L7;
        r100 = true;
        goto L8
    }

    public BitableFieldEditFragment() {
        this.f211182x = LazyKt.lazy(new BitableFieldEditFragment$mFieldEditViewModel$2(this));
        this.f211184z = LazyKt.lazy(new BitableFieldEditFragment$mStatusBar$2(this));
        this.B = true;
        this.C = LazyKt.lazy(new BitableFieldEditFragment$mBitableAnalytic$2(this));
        this.D = new LinkedHashMap();
        this.E = true;
    }

    public final void W90() {
        rcb.c.c(getContext());
        da0().getFieldEditPanelActive().setValue(Boolean.FALSE);
    }

    public final void ea0() {
        View r100 = null;
        da0().getShortcutConfig().setValue(null);
        View r101 = this.f211167i;
        if (r101 != null) goto L9;
        View r102 = getView();
        if (r102 == null) goto L7;
        r101 = r102.findViewById(R.id.fieldShortcutContainer);
    L8:
        this.f211167i = (LinearLayout) r101;
        goto L9
    L7:
        r101 = null;
    L9:
        ((LinearLayout) r101).setVisibility(8);
        if (ja0() == false) goto L18;
        da0().getHideFieldProperty().setValue(Boolean.TRUE);
        aa0().setBackgroundTintList(null);
        aa0().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bitable_field_shortcut_wrapper_bg_without_shortcut, null));
        View r103 = this.f211169k;
        if (r103 != null) goto L17;
        View r104 = getView();
        if (r104 == null) goto L16;
        r100 = r104.findViewById(R.id.fieldRightIcon);
    L16:
        this.f211169k = (AppCompatImageView) r100;
        r103 = r100;
    L17:
        ((AppCompatImageView) r103).setVisibility(8);
        return;
    L18:
        da0().getHideFieldProperty().setValue(Boolean.FALSE);
        aa0().setBackgroundTintList(ResourcesCompat.getColorStateList(getResources(), R.color.facade_selector_item_float, null));
        aa0().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.facade_round_around_xl, null));
        View r105 = this.f211169k;
        if (r105 != null) goto L24;
        View r106 = getView();
        if (r106 == null) goto L23;
        r100 = r106.findViewById(R.id.fieldRightIcon);
    L23:
        this.f211169k = (AppCompatImageView) r100;
        r105 = r100;
    L24:
        ((AppCompatImageView) r105).setVisibility(0);
    }

    public final void ga0() {
        FieldCompositeType r100 = da0().getCurrentEditFieldCompositeType();
        if (r100 != null) goto L5;
        r100 = new FieldCompositeType();
    L5:
        BitableFieldEditViewModel.c r101 = da0().getCurrentEditFieldInfo().getValue();
        String r102 = null;
        if (r101 == null) goto L10;
        FieldExtendInfo r103 = r101.f211802b;
        if (r103 == null) goto L10;
        EExtendInfo r104 = r103.getExtendInfo();
    L11:
        BitableFieldEditAnalytic r105 = ca0();
        if (r105 == null) goto L35;
        String r106 = this.I;
        long r107 = System.currentTimeMillis() - this.K;
        Pair[] r108 = new Pair[3];
        if (r101 == null) goto L22;
        FieldExtendInfo r109 = r101.f211802b;
        if (r109 == null) goto L22;
        FieldExtendFieldBaseInfo r110 = r109.getOriginField();
        if (r110 == null) goto L22;
        FieldCompositeType r111 = r110.getFieldCompositeType();
        if (r111 == null) goto L22;
        String r112 = r111.getReportValue();
    L23:
        r108[0] = TuplesKt.to("extend_from_field_type", r112);
        if (r104 == null) goto L26;
        String r113 = "true";
    L27:
        r108[1] = TuplesKt.to("is_extend", r113);
        if (r104 == null) goto L30;
        r102 = r104.getExtendFieldType();
    L30:
        r108[2] = TuplesKt.to("extend_field_type", r102);
        Map r114 = MapsKt.mapOf(r108);
        HashMap r115 = new HashMap();
        r115.put("field_type", r100.getReportValue());
        r115.put("action_type", r106);
        r115.put("duration", Long.valueOf(r107));
        if (r114 == null) goto L33;
        r115.putAll(r114);
    L33:
        r105.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_MODIFY_DURATION_VUEW, r115);
        return;
    L26:
        r113 = "false";
    L22:
        r112 = null;
        goto L23
    L35:
        return;
    L10:
        r104 = null;
        goto L11
    }

    public final void ka0() {
        FieldCompositeType r100 = da0().getCurrentEditFieldCompositeType();
        BitableFieldEditAnalytic r101 = ca0();
        boolean r102 = false;
        if (r101 == null) goto L9;
        q0 r103 = this.f211183y;
        if (r103 == null) goto L7;
        boolean r104 = r103.c();
    L8:
        r101.Q(r100, "cancel", r104, null, new HashMap());
        goto L9
    L7:
        r104 = false;
    L9:
        ga0();
        BitableFieldEditAnalytic r105 = ca0();
        FieldCompositeType r106 = null;
        if (r105 == null) goto L12;
        r105.U("cancel", null);
    L12:
        String r107 = String.valueOf(Y90().getText());
        FieldEditPanelData r108 = da0().getPanelData().getValue();
        if (r108 == null) goto L16;
        String r109 = r108.getFieldName();
        if (r109 == null) goto L16;
    L17:
        boolean r110 = !TextUtils.equals(r107, r109);
        FieldEditPanelData r111 = da0().getPanelData().getValue();
        if (r111 == null) goto L20;
        r106 = r111.getFieldCompositeType();
    L20:
        boolean r112 = !Intrinsics.areEqual(r106, r100);
        q0 r113 = this.f211183y;
        if (r113 != null) goto L23;
    L25:
        boolean r114 = false;
    L26:
        q0 r115 = this.f211183y;
        if (r115 != null) goto L29;
    L31:
        boolean r116 = false;
    L32:
        q0 r117 = this.f211183y;
        if (r117 != null) goto L35;
    L37:
        if (r110 == true) goto L44;
        if (r112 == true) goto L44;
        if (r114 == true) goto L44;
        if (r116 == true) goto L44;
        if (r102 == true) goto L44;
        W90();
        return;
    L44:
        com.bytedance.ee.bear.widgets.a r118 = new com.bytedance.ee.bear.widgets.a(getContext());
        r118.j(R.string.Bitable_Field_ChangesUnsavedDesc);
        r118.h(R.string.Bitable_Field_ChangesUnsavedButtonLeave, new f(this));
        r118.b(new g(this));
        r118.q();
        BitableFieldEditAnalytic r119 = ca0();
        if (r119 == null) goto L49;
        r119.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_MODIFY_CANCEL_CONFIRM_VIEW, new HashMap());
        return;
    L49:
        return;
    L35:
        if (r117.k() != true) goto L37;
        r102 = true;
        goto L37
    L29:
        if (r115.g() != true) goto L31;
        r116 = true;
        goto L32
    L23:
        if (r113.b() != true) goto L25;
        r114 = true;
    L16:
        r109 = "";
        goto L17
    }

    public final void ma0() {
        Object r100 = null;
        boolean r101 = false;
        if (ja0() == false) goto L12;
        aa0().setClickable(false);
        Object r102 = this.f211171m;
        if (r102 != null) goto L10;
        View r103 = getView();
        if (r103 == null) goto L9;
        r100 = r103.findViewById(R.id.fieldTypeSelectorWrapper);
    L9:
        this.f211171m = (LinearLayout) r100;
        r102 = r100;
    L10:
        ((LinearLayout) r102).setOnClickListener(new h(this));
        return;
    L12:
        LinearLayout r104 = aa0();
        if (r104 != null) goto L15;
        return;
    L15:
        View r105 = this.f211172n;
        if (r105 != null) goto L22;
        View r106 = getView();
        if (r106 == null) goto L20;
        r105 = r106.findViewById(R.id.fieldTypeIV);
    L21:
        this.f211172n = (SyncIconImageView) r105;
        goto L22
    L20:
        r105 = null;
    L22:
        SyncIconImageView r107 = (SyncIconImageView) r105;
        if (r107 != null) goto L25;
        return;
    L25:
        BitableFieldEditViewModel.c r108 = da0().getCurrentEditFieldInfo().getValue();
        if (r108 == null) goto L28;
        FieldExtendInfo r109 = r108.f211802b;
    L30:
        if (r109 != null) goto L32;
    L35:
        boolean r110 = true;
    L36:
        r104.setClickable(r110);
        if (r109 == null) goto L39;
        r100 = r109.getExtendInfo();
    L39:
        if (r100 == null) goto L41;
        boolean r111 = true;
    L42:
        r107.setSyncIconVisible(r111);
        if (r110 == false) goto L52;
        FieldEditPanelData r112 = da0().getPanelData().getValue();
        if (r112 != null) goto L47;
    L49:
        if (r101 == true) goto L52;
        r107.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(R.color.icon_n1)));
        ba0().setTextColor(UIHelper.getColor(R.color.icon_n1));
        r104.setOnClickListener(new j(this));
        return;
    L47:
        if (r112.disableConvertField() != true) goto L49;
        r101 = true;
    L52:
        r107.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(R.color.text_disabled)));
        ba0().setTextColor(UIHelper.getColor(R.color.text_disabled));
        r104.setOnClickListener(new i(r110, this));
        return;
    L41:
        r111 = false;
        goto L42
    L32:
        if (r109.getEditable() == true) goto L35;
        r110 = false;
        goto L36
    L28:
        r109 = null;
        goto L30
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        if (super.onBackPressed() == true) goto L7;
        ka0();
        return true;
    L7:
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        q0 r100 = this.f211183y;
        if (r100 == null) goto L6;
        r100.onDetach();
        this.f211183y = null;
    L6:
        if (lr4.a.a(da0().getCurrentEditFieldCompositeType()) == false) goto L10;
        BitableFieldEditAnalytic r101 = ca0();
        if (r101 == null) goto L10;
        r101.b0(da0().getCurrentEditFieldCompositeType(), System.currentTimeMillis() - this.F);
    L10:
        ((xu5.a) this.f211184z.getValue()).resetState();
        Iterator r102 = ((LinkedHashMap) this.D).values().iterator();
    L12:
        if (r102.hasNext() == false) goto L16;
        Disposable r103 = (Disposable) r102.next();
        if (r103 == null) goto L12;
        r103.dispose();
        goto L12
    L16:
        ((LinkedHashMap) this.D).clear();
        this.f211163e = null;
        this.f211164f = null;
        this.f211165g = null;
        this.f211166h = null;
        this.f211167i = null;
        this.f211168j = null;
        this.f211169k = null;
        this.f211170l = null;
        this.f211171m = null;
        this.f211172n = null;
        this.f211173o = null;
        this.f211174p = null;
        this.f211175q = null;
        this.f211176r = null;
        this.f211177s = null;
        this.f211178t = null;
        this.f211179u = null;
        this.f211180v = null;
        this.f211181w = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L20;
        FieldEditPanelData r100 = da0().getPanelData().getValue();
        if (r100 == null) goto L7;
        String r101 = r100.getSrcObjToken();
    L8:
        FieldEditPanelData r102 = da0().getPanelData().getValue();
        if (r102 == null) goto L11;
        Integer r103 = r102.getSrcObjType();
    L12:
        int r104 = WatermarkUtils.f209802a;
        FrameLayout r105 = (FrameLayout) this.N;
        if (r105 == null) goto L18;
        if (r101 == null) goto L17;
        if (r103 == null) goto L17;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).l(r101, r103.intValue(), r105);
        WatermarkUtils.AddWaterMarkStatus r106 = WatermarkUtils.AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
        return;
    L17:
        WatermarkUtils.AddWaterMarkStatus r107 = WatermarkUtils.AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
        return;
    L18:
        tt5.a.k("WatermarkUtils", "can not add watermark for empty framelayout");
        WatermarkUtils.AddWaterMarkStatus r108 = WatermarkUtils.AddWaterMarkStatus.STATUS_SUCCESS_WITH_SRC_OBJ;
        return;
    L11:
        r103 = null;
        goto L12
    L7:
        r101 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        q0 r101 = this.f211183y;
        if (r101 == null) goto L5;
        r101.onConfigurationChanged(r100);
    L5:
        rcb.c.c(getContext());
    }

    public final Fragment V90(String r100, Bundle r101) {
        rcb.c.c(getContext());
        if (r101 != null) goto L5;
        r101 = new Bundle();
    L5:
        PluginHost.writePluginHostToBundle(this, r101);
        Fragment r102 = getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), r100);
        r102.setArguments(r101);
        if ((r102 instanceof DialogFragment) == false) goto L12;
        DialogFragment r103 = (DialogFragment) r102;
        FragmentManager r104 = getChildFragmentManager();
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r100, r105);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r103, r105) == false) goto L19;
    L17:
        return r102;
    L19:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L11:
        r103.show(r104, r100);
        goto L17
    L12:
        FragmentTransaction r106 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r106, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.rootView) == true) goto L16;
        r106 = r106.replace(R.id.rootView, r102);
    L16:
        r106.commitAllowingStateLoss();
        goto L17
    }

    public final void fa0(boolean r100, String r101) {
        this.B = r100;
        if (r100 == false) goto L5;
        Y90().w();
    L6:
        View r102 = this.f211181w;
        if (r102 != null) goto L13;
        View r103 = getView();
        if (r103 == null) goto L11;
        r102 = r103.findViewById(R.id.fieldNameErrorBg);
    L12:
        this.f211181w = (UDTextInputLayout) r102;
        goto L13
    L11:
        r102 = null;
    L13:
        ((UDTextInputLayout) r102).b(r101);
        la0();
        return;
    L5:
        Y90().v();
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ((xu5.a) this.f211184z.getValue()).saveState();
        this.H = da0().getSceneType();
        FieldEditPanelData r100 = da0().getPanelData().getValue();
        boolean r101 = true;
        if (r100 == null) goto L10;
        Integer r102 = r100.getType();
        int r103 = FieldEditPanelData.EPanelAction.ADD_FIELD.getValue();
        if (r102 == null) goto L10;
        if (r102.intValue() != r103) goto L10;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        String r105 = "new_field";
    L15:
        this.I = r105;
        if (TextUtils.equals("new_field", r105) == true) goto L18;
        this.f211162J = da0().getCurrentEditFieldCompositeType();
    L18:
        View r106 = this.f211163e;
        if (r106 != null) goto L25;
        View r107 = getView();
        if (r107 == null) goto L23;
        r106 = r107.findViewById(R.id.titleBar);
    L24:
        this.f211163e = (BaseTitleBar) r106;
        goto L25
    L23:
        r106 = null;
    L25:
        BaseTitleBar r108 = (BaseTitleBar) r106;
        FieldEditPanelData r109 = da0().getPanelData().getValue();
        if (r109 == null) goto L33;
        Integer r112 = r109.getType();
        int r113 = FieldEditPanelData.EPanelAction.ADD_FIELD.getValue();
        if (r112 == null) goto L33;
        if (r112.intValue() != r113) goto L33;
        boolean r114 = true;
    L34:
        if (r114 == false) goto L36;
        int r115 = R.string.Bitable_BTModule_AddField;
    L37:
        r108.setTitle(r115);
        r108.setLeftIconVisibility(false);
        r108.setLeftText(R.string.Bitable_Common_ButtonCancel);
        r108.setLeftTextColor(r108.getResources().getColor(R.color.primary_fill_default));
        r108.setLeftClickListener(new e0(this));
        BaseTitleBar.e r116 = new BaseTitleBar.e(getString(R.string.Bitable_Common_ButtonSave), R.color.primary_fill_default);
        this.A = r116;
        r108.a(r116, true).setOnClickListener(new f0(this));
        FieldEditText r117 = Y90();
        r117.setActivated(true);
        FieldEditPanelData r118 = da0().getPanelData().getValue();
        if (r118 == null) goto L40;
        String r119 = r118.getFieldName();
    L41:
        r117.setText(r119);
        r117.setHint(getString(R.string.Bitable_Field_PleaseEnterFieldName));
        r117.addTextChangedListener(new h0(this, r117));
        r117.setOnFocusChangeListener(new g0(r117, this));
        View r120 = this.f211170l;
        if (r120 != null) goto L48;
        View r121 = getView();
        if (r121 == null) goto L46;
        r120 = r121.findViewById(R.id.notice);
    L47:
        this.f211170l = (UDNotice) r120;
        goto L48
    L46:
        r120 = null;
    L48:
        UDNotice r122 = (UDNotice) r120;
        FieldEditPanelData.EEditNotice.a r123 = FieldEditPanelData.EEditNotice.Companion;
        FieldEditPanelData r124 = da0().getPanelData().getValue();
        if (r124 == null) goto L51;
        Integer r125 = r124.getEditNotice();
    L52:
        r123.getClass();
        FieldEditPanelData.EEditNotice r126 = FieldEditPanelData.EEditNotice.a.a(r125);
        String r127 = "true";
        if (r126 != null) goto L55;
        r122.setVisibility(8);
    L123:
        ma0();
        int r128 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.base.fields_shortcut.enable") == false) goto L126;
        da0().getShowAIConfigLayout().setValue(Boolean.FALSE);
        da0().getAiPromptTx().setValue("");
        tt5.a.h("BitableFieldEditFragment", "hide AI config layout");
        X90().setVisibility(8);
    L134:
        ea0();
        View r129 = this.f211165g;
        if (r129 != null) goto L141;
        View r130 = getView();
        if (r130 == null) goto L139;
        r129 = r130.findViewById(R.id.fieldBaseMetaContainer);
    L140:
        this.f211165g = (LinearLayout) r129;
        goto L141
    L139:
        r129 = null;
    L141:
        LinearLayout r131 = (LinearLayout) r129;
        MutableLiveData<FieldEditPanelData> r132 = da0().getPanelData();
        if (r132 == null) goto L148;
        FieldEditPanelData r133 = r132.getValue();
        if (r133 == null) goto L148;
        if (r133.isEditOptionMode() != true) goto L148;
        boolean r134 = true;
    L149:
        com.bytedance.ee.bear.bitable.m.z(r131, !r134);
        da0().getCurrentEditFieldInfo().observe(getViewLifecycleOwner(), new u(this));
        da0().getCurrentSelectedPropertyOption().observe(getViewLifecycleOwner(), new v(this));
        da0().getShowAIConfigLayout().observe(getViewLifecycleOwner(), new w(this));
        da0().getFieldExtendConfigs().observe(getViewLifecycleOwner(), new x(this));
        da0().getPanelData().observe(getViewLifecycleOwner(), new y(this));
        da0().getShortcutConfig().observe(getViewLifecycleOwner(), new z(this));
        da0().getHideFieldProperty().observe(getViewLifecycleOwner(), new a0(this));
        da0().fetchOriginFieldsInfoIfNeed();
        if (ja0() == false) goto L152;
        da0().fetchShortcutConfig();
    L152:
        FieldEditPanelData r135 = da0().getPanelData().getValue();
        BitableFieldEditAnalytic r136 = ca0();
        if (r136 == null) goto L191;
        FieldCompositeType r137 = da0().getCurrentEditFieldCompositeType();
        if (r135 == null) goto L157;
        int r138 = r135.getFieldIndex();
    L158:
        String r139 = this.I;
        String r140 = this.H;
        Pair[] r141 = new Pair[3];
        if (r135 == null) goto L167;
        FieldExtendInfo r142 = r135.getFieldExtendInfo();
        if (r142 == null) goto L167;
        FieldExtendFieldBaseInfo r143 = r142.getOriginField();
        if (r143 == null) goto L167;
        FieldCompositeType r144 = r143.getFieldCompositeType();
        if (r144 == null) goto L167;
        String r145 = r144.getReportValue();
    L168:
        r141[0] = TuplesKt.to("extend_from_field_type", r145);
        if (r135 == null) goto L171;
        FieldExtendInfo r146 = r135.getFieldExtendInfo();
    L172:
        if (r146 != null) goto L174;
        r127 = "false";
    L174:
        r141[1] = TuplesKt.to("is_extend", r127);
        if (r135 == null) goto L181;
        FieldExtendInfo r147 = r135.getFieldExtendInfo();
        if (r147 == null) goto L181;
        EExtendInfo r148 = r147.getExtendInfo();
        if (r148 == null) goto L181;
        String r149 = r148.getExtendFieldType();
    L182:
        r141[2] = TuplesKt.to("extend_field_type", r149);
        Map r150 = MapsKt.mapOf(r141);
        HashMap r151 = new HashMap();
        r151.put("field_type", r137.getReportValue());
        if (r138 == 0) goto L186;
        r101 = false;
    L186:
        r151.put("is_index_column", String.valueOf(r101));
        r151.put("action_type", r139);
        r151.put("scene_type", r140);
        if (r150 == null) goto L189;
        r151.putAll(r150);
    L189:
        r136.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_MODIFY_VIEW, r151);
        return;
    L181:
        r149 = null;
        goto L182
    L171:
        r146 = null;
    L167:
        r145 = null;
        goto L168
    L157:
        r138 = 0;
        goto L158
    L191:
        return;
    L148:
        r134 = false;
        goto L149
    L126:
        X90().setVisibility(0);
        FieldEditPanelData r152 = da0().getPanelData().getValue();
        if (r152 == null) goto L131;
        da0().getShowAIConfigLayout().setValue(Boolean.valueOf(r152.getCanShowAIConfig()));
        String r153 = r152.getShowAIConfigTx();
        if (r153 == null) goto L131;
        da0().getAiPromptTx().setValue(r153);
    L131:
        LinearLayout r154 = X90();
        if (r154 == null) goto L134;
        r154.setOnClickListener(new b0(this));
        goto L134
    L55:
        r122.setVisibility(0);
        FieldEditPanelData r155 = da0().getPanelData().getValue();
        if (r155 == null) goto L58;
        FieldExtendInfo r156 = r155.getFieldExtendInfo();
    L59:
        if (r156 == null) goto L63;
        EExtendInfo r157 = r156.getExtendInfo();
        if (r157 == null) goto L63;
        FieldCompositeType r158 = r157.getOriginFieldCompositeType();
    L64:
        int[] r159 = b.f211187a;
        int r160 = r159[r126.ordinal()];
        if (r160 == 1) goto L76;
        if (r160 == 2) goto L75;
        if (r160 == 3) goto L74;
        if (r160 == 4) goto L73;
        if (r160 != 5) goto L72;
        r122.setText(R.string.Bitable_PeopleField_SyncPauseDueToAllowAddMultiplePerson_Description);
        r122.k6(false);
    L77:
        BitableFieldEditAnalytic r161 = ca0();
        if (r161 == null) goto L107;
        Pair[] r162 = new Pair[3];
        if (r158 == null) goto L82;
        String r163 = r158.getReportValue();
    L83:
        r162[0] = TuplesKt.to("from_field_type", r163);
        int r164 = r159[r126.ordinal()];
        if (r164 == 1) goto L95;
        if (r164 == 2) goto L95;
        if (r164 != 3) goto L88;
    L94:
        String r165 = "field_delete";
    L96:
        r162[1] = TuplesKt.to("error_type", r165);
        FieldExtendConfigs r166 = da0().getFieldExtendConfigs().getValue();
        if (r166 == null) goto L99;
        boolean r167 = Intrinsics.areEqual(r166.isOwner(), Boolean.TRUE);
    L100:
        if (r167 == false) goto L102;
        Object r168 = "true";
    L103:
        r162[2] = TuplesKt.to("is_owner", r168);
        Map r169 = MapsKt.mapOf(r162);
        HashMap r170 = new HashMap();
        if (r169 == null) goto L106;
        r170.putAll(r169);
    L106:
        r161.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_EXTEND_SYNC_ERROR_VIEW, r170);
        goto L107
    L102:
        r168 = "false";
        goto L103
    L99:
        r167 = false;
        goto L100
    L88:
        if (r164 == 4) goto L94;
        if (r164 != 5) goto L93;
        r165 = "multiple_enable";
        goto L96
    L93:
        throw new NoWhenBranchMatchedException();
    L95:
        r165 = "permission_limited";
        goto L96
    L82:
        r163 = null;
    L107:
        BitableFieldEditAnalytic r171 = ca0();
        if (r171 == null) goto L123;
        Pair[] r172 = new Pair[2];
        if (r158 == null) goto L112;
        String r173 = r158.getReportValue();
    L113:
        r172[0] = TuplesKt.to("extend_from_field_type", r173);
        if (r156 == null) goto L118;
        EExtendInfo r174 = r156.getExtendInfo();
        if (r174 == null) goto L118;
        String r175 = r174.getExtendFieldType();
    L119:
        r172[1] = TuplesKt.to("extend_field_type", r175);
        Map r176 = MapsKt.mapOf(r172);
        HashMap r177 = new HashMap();
        if (r176 == null) goto L122;
        r177.putAll(r176);
    L122:
        r171.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_MODIFY_BOARD_EXTEND_WARNING_VIEW, r177);
    L118:
        r175 = null;
        goto L119
    L112:
        r173 = null;
        goto L113
    L72:
        throw new NoWhenBranchMatchedException();
    L73:
        r122.setText(R.string.Bitable_PeopleField_Error_PeopleFieldNotExist_Toast);
        r122.k6(false);
        goto L77
    L74:
        r122.setText(R.string.Bitable_PeopleField_SourceFieldNotExisted_SwitchToNormalField_Description);
        r122.setTextButton(r122.getContext().getString(R.string.Bitable_PeopleField_Switch_Button));
        r122.setTextButtonListener(new d0(r122, this, r158, r156));
        goto L77
    L75:
        r122.setText(R.string.Bitable_PeopleField_Error_SyncPausedDueToOwnerChangedContactOwner_Toast);
        r122.k6(false);
        goto L77
    L76:
        r122.setText(R.string.Bitable_PeopleField_Error_SyncPausedDueToOwnerChanged_Toast);
        r122.setTextButton(r122.getContext().getString(R.string.Bitable_PeopleField_Resync_Button));
        r122.setTextButtonListener(new c0(this, r158, r156));
    L63:
        r158 = null;
        goto L64
    L58:
        r156 = null;
        goto L59
    L51:
        r125 = null;
        goto L52
    L40:
        r119 = null;
        goto L41
    L36:
        r115 = R.string.Bitable_BTModule_EditField;
    L33:
        r114 = false;
        goto L34
    L14:
        r105 = BitableFieldEditAnalytic.FieldModifyAction.EXISTED_FIELD;
    L10:
        r104 = false;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final Animation onCreateAnimation(int r100, boolean r101, int r102) {
        Context r103 = getContext();
        if (r101 == false) goto L5;
        int r104 = R.anim.facade_translate_from_bottom;
    L6:
        Animation r105 = AnimationUtils.loadAnimation(r103, r104);
        r105.setAnimationListener(new c(r101, this));
        return r105;
    L5:
        r104 = R.anim.facade_translate_to_bottom;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        long r103 = System.currentTimeMillis();
        this.F = r103;
        this.K = r103;
        if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L6;
        View r104 = r100.inflate(R.layout.bitable_field_edit_fragment_new_perm, r101, false);
        this.N = r104;
        return r104;
    L6:
        return r100.inflate(R.layout.bitable_field_edit_fragment, r101, false);
    }

    public static final void U90(BitableFieldEditFragment r110, FieldCompositeType r111, FieldProperty r210, AllowedEditModes r211, ExtendFieldOptions r212, FieldExtendBean r213, Boolean r214) {
        FieldEditPanelData r100 = r110.da0().getPanelData().getValue();
        if (r100 == null) goto L10;
        Integer r101 = r100.getType();
        int r102 = FieldEditPanelData.EPanelAction.ADD_FIELD.getValue();
        if (r101 == null) goto L10;
        if (r101.intValue() != r102) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        r110.ha0(r111, r210, r211, r212, r213, null, r214);
        return;
    L13:
        Map<FieldEditFragmentDisposeName, Disposable> r104 = r110.D;
        FieldEditFragmentDisposeName r105 = FieldEditFragmentDisposeName.Save;
        Disposable r106 = (Disposable) ((LinkedHashMap) r104).get(r105);
        if (r106 == null) goto L16;
        r106.dispose();
    L16:
        Map<FieldEditFragmentDisposeName, Disposable> r107 = r110.D;
        Observable<CheckResult> r112 = r110.da0().checkConfirm(r111, String.valueOf(r110.Y90().getText()), r210, r211, r212, r213, r214);
        if (r112 == null) goto L19;
        Disposable r108 = r112.subscribe(new k(r110, r111, r210, r211, r212, r213, r214), l.f211441a);
    L20:
        r107.put(r105, r108);
        return;
    L19:
        r108 = null;
    L10:
        r103 = false;
        goto L11
    }

    public final void ha0(FieldCompositeType r110, FieldProperty r111, AllowedEditModes r112, ExtendFieldOptions r113, FieldExtendBean r114, CheckConfirmValue r115, Boolean r116) {
        Map<FieldEditFragmentDisposeName, Disposable> r100 = this.D;
        FieldEditFragmentDisposeName r101 = FieldEditFragmentDisposeName.Save;
        Disposable r102 = (Disposable) ((LinkedHashMap) r100).get(r101);
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        Map<FieldEditFragmentDisposeName, Disposable> r103 = this.D;
        Observable<FieldCommandResult> r104 = da0().updateFieldEditData(r110, String.valueOf(Y90().getText()), r111, r112, r115, r113, r114, r116);
        if (r104 == null) goto L8;
        Disposable r105 = r104.subscribe(new d(this), new e(this));
    L9:
        r103.put(r101, r105);
        return;
    L8:
        r105 = null;
        goto L9
    }

    public static /* synthetic */ void ia0(BitableFieldEditFragment r100, FieldCompositeType r101, FieldProperty r110, AllowedEditModes r111, ExtendFieldOptions r112, FieldExtendBean r113, CheckConfirmValue r114, int r115) {
        if ((r115 & 32) == 0) goto L5;
        r114 = null;
    L5:
        r100.ha0(r101, r110, r111, r112, r113, r114, null);
    }
}
