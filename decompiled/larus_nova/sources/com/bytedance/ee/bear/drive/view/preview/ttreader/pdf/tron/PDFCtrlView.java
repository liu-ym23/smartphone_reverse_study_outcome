package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SizeF;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bytedance.ee.bear.drive.biz.comment.data.CommentQuote;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveViewFullScreenVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.pdf.DrivePdfState;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.ee.plugin.common.ttpdfreader.TTReaderSelectionInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 Õ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Õ\u0001B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010g\u001a\u00020h2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020;2\u0006\u0010i\u001a\u00020P2\u0006\u0010@\u001a\u00020A2\u0006\u0010[\u001a\u00020\\J\b\u0010j\u001a\u00020hH\u0002J\b\u0010k\u001a\u00020hH\u0002J\b\u0010l\u001a\u00020hH\u0002J\b\u0010m\u001a\u00020hH\u0002J\b\u0010n\u001a\u00020hH\u0002J\u0010\u0010o\u001a\u00020h2\u0006\u0010p\u001a\u00020MH\u0002J\u000e\u0010q\u001a\u00020h2\u0006\u0010r\u001a\u00020PJ\b\u0010s\u001a\u00020hH\u0002J\b\u0010t\u001a\u00020hH\u0002J\b\u0010u\u001a\u00020hH\u0002J\b\u0010v\u001a\u00020hH\u0002J\u0010\u0010w\u001a\u00020h2\b\u0010x\u001a\u0004\u0018\u00010yJ\b\u0010z\u001a\u00020hH\u0014J\b\u0010~\u001a\u00020hH\u0016J\b\u0010\u007f\u001a\u00020hH\u0002J\t\u0010\u0080\u0001\u001a\u00020EH\u0016J\u001d\u0010\u0081\u0001\u001a\u00020h2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010E2\u0007\u0010\u0083\u0001\u001a\u00020MH\u0016J\u0014\u0010\u0084\u0001\u001a\u00020h2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010yH\u0002J\u0013\u0010\u0086\u0001\u001a\u00020h2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020hH\u0002J\u0015\u0010\u008a\u0001\u001a\u00020h2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0014J\u0012\u0010\u008b\u0001\u001a\u00020P2\u0007\u0010\u008c\u0001\u001a\u00020MH\u0002J\u0010\u0010\u008d\u0001\u001a\u00020h2\u0007\u0010\u008c\u0001\u001a\u00020MJ\u0013\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010p\u001a\u00030\u0090\u0001H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020P2\u0007\u0010\u0083\u0001\u001a\u00020MH\u0003J\t\u0010\u0092\u0001\u001a\u00020hH\u0002J\u0012\u0010\u0093\u0001\u001a\u00020h2\u0007\u0010\u0094\u0001\u001a\u00020PH\u0002J\t\u0010\u0095\u0001\u001a\u00020PH\u0002J\u0014\u0010\u0081\u0001\u001a\u00020h2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010EH\u0016J\u0014\u0010\u0096\u0001\u001a\u00020h2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010CH\u0016J\u0013\u0010\u0098\u0001\u001a\u00020h2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010\u0099\u0001\u001a\u00020M2\u0007\u0010\u009a\u0001\u001a\u00020MH\u0016J\t\u0010\u009b\u0001\u001a\u00020MH\u0016J\t\u0010\u009c\u0001\u001a\u00020MH\u0016J\u0012\u0010\u009d\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020MH\u0016J\u0012\u0010\u009e\u0001\u001a\u00020P2\u0007\u0010\u0083\u0001\u001a\u00020MH\u0016J\u0012\u0010\u009f\u0001\u001a\u00020P2\u0007\u0010\u009a\u0001\u001a\u00020MH\u0002J\u0014\u0010 \u0001\u001a\u00020h2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010IH\u0016J\u001b\u0010¡\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020M2\u0007\u0010¢\u0001\u001a\u00020MH\u0016J\t\u0010£\u0001\u001a\u00020MH\u0016J\u0014\u0010¤\u0001\u001a\u00020h2\t\u0010¥\u0001\u001a\u0004\u0018\u00010VH\u0016J\u0013\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010\u009a\u0001\u001a\u00020MH\u0016J\n\u0010¨\u0001\u001a\u00030©\u0001H\u0016J\t\u0010ª\u0001\u001a\u00020MH\u0016J\u0011\u0010«\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0083\u0001\u001a\u00020MJ\u0011\u0010¬\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0083\u0001\u001a\u00020MJ\u0007\u0010\u00ad\u0001\u001a\u00020PJ\u0007\u0010®\u0001\u001a\u00020PJE\u0010¯\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010\u0083\u0001\u001a\u00020M2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u00012\u0007\u0010´\u0001\u001a\u00020M2\u0007\u0010µ\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020PJ\u0019\u0010·\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010´\u0001\u001a\u00020MJE\u0010¸\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010\u0083\u0001\u001a\u00020M2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u00012\u0007\u0010´\u0001\u001a\u00020M2\u0007\u0010µ\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020PJ\u0019\u0010¹\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010´\u0001\u001a\u00020MJ\u0010\u0010º\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020yJ\u0007\u0010»\u0001\u001a\u00020hJ\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001J\u0007\u0010¾\u0001\u001a\u00020PJ\u0007\u0010¿\u0001\u001a\u00020hJ\u0010\u0010À\u0001\u001a\u00020h2\u0007\u0010Á\u0001\u001a\u00020PJ\u0007\u0010Â\u0001\u001a\u00020hJ\u0007\u0010Ã\u0001\u001a\u00020hJ\n\u0010Ä\u0001\u001a\u0005\u0018\u00010½\u0001J\u0007\u0010Å\u0001\u001a\u00020hJ\u0007\u0010Æ\u0001\u001a\u00020hJ\u000f\u0010Ç\u0001\u001a\u00020h2\u0006\u0010a\u001a\u00020bJ\u0007\u0010È\u0001\u001a\u00020hJ\n\u0010É\u0001\u001a\u0005\u0018\u00010½\u0001J\u000f\u0010Ê\u0001\u001a\u00020h2\u0006\u0010a\u001a\u00020bJ\u0007\u0010Ë\u0001\u001a\u00020hJ\u0007\u0010Ì\u0001\u001a\u00020hJ\u0007\u0010Í\u0001\u001a\u00020hJ\u0007\u0010Î\u0001\u001a\u00020hJ\b\u0010Ï\u0001\u001a\u00030½\u0001J\u0010\u0010Ð\u0001\u001a\u00020h2\u0007\u0010\u0083\u0001\u001a\u00020MJ\u0007\u0010Ñ\u0001\u001a\u00020hJ\u0007\u0010Ò\u0001\u001a\u00020hJ\t\u0010Ó\u0001\u001a\u0004\u0018\u00010yJ\t\u0010Ô\u0001\u001a\u00020hH\u0002R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u0004\u0018\u00010/8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010{\u001a\u00020y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006Ö\u0001"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFCtrlView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer;", "Lcom/bytedance/ee/bear/drive/module/nativepreview/model/OnViewNeedReleaseListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pdfThumbnailViewFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;", "getPdfThumbnailViewFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;", "setPdfThumbnailViewFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;)V", "presentationViewFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/pdf/presentationview/PdfPresentationView;", "getPresentationViewFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/pdf/presentationview/PdfPresentationView;", "setPresentationViewFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/pdf/presentationview/PdfPresentationView;)V", "pdfContentViewFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView;", "getPdfContentViewFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView;", "setPdfContentViewFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView;)V", "blockIndicatorFromXml", "Landroid/widget/TextView;", "getBlockIndicatorFromXml", "()Landroid/widget/TextView;", "setBlockIndicatorFromXml", "(Landroid/widget/TextView;)V", "pdfThumbnailSliderFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailSlider;", "getPdfThumbnailSliderFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailSlider;", "setPdfThumbnailSliderFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailSlider;)V", "pdfThumbnailToggleViewFromXml", "Landroid/widget/ImageView;", "getPdfThumbnailToggleViewFromXml", "()Landroid/widget/ImageView;", "setPdfThumbnailToggleViewFromXml", "(Landroid/widget/ImageView;)V", "pdfToWpsEditFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getPdfToWpsEditFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setPdfToWpsEditFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "indicatorViewFromXml", "getIndicatorViewFromXml", "setIndicatorViewFromXml", "parentViewOwner", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;", "viewOwner", "viewModel", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFCtrlViewModel;", "componentRenderVM", "Lcom/bytedance/ee/bear/drive/module/nativepreview/model/DriveComponentRenderVM;", "blockVM", "Lcom/bytedance/ee/bear/drive/view/preview/block/DriveBlockPreviewVM;", "vcReadyCallback", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/connector/IVCFollowReadyCallback;", "scrollListener", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer$ScrollListener;", "exhibitionMode", "Lcom/bytedance/ee/bear/drive/view/preview/pdf/ExhibitionMode;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "pdfActionListener", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer$IPDFActionListener;", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "presentationTargetWidth", "", "presentationTargetHeight", "defaultEnterPresentation", "", "presentationPageDis", "Lio/reactivex/disposables/Disposable;", "state", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/DrivePdfState;", "mListenerConfigurationChange", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer$ConfigurationChangedCallBack;", "mInVc", "mDriveConfigurationVM", "Lcom/bytedance/ee/bear/drive/biz/preview/configuration/DriveConfigurationVM;", "disableIndicatorAnimFlag", "userComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "commentRectLayout", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectLayout;", "commentRectLayoutHelper", "Lcom/bytedance/ee/bear/drive/biz/comment/CommentRectLayoutHelper;", "selectionData", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/SelectionData;", "mStatusBarManager", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "onboardingController", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/onboarding/DrivePdfCommentAreaOnboardingController;", "init", "", "inVC", "initView", "initCommentRectLayout", "addCommentRectLayout", "removeCommentRectLayout", "bindView", "updateIndicator", "page", "setDefaultEnterPresentation", "enable", "checkDefaultExhibitionMode", "handleShowLeftTopIndicator", "handleShowThumbnailIndicator", "bindListener", "open", "password", "", "onDetachedFromWindow", "releaseKey", "getReleaseKey", "()Ljava/lang/String;", "onRelease", "removeObservers", "getCurrentMode", "setExhibitionMode", "mode", "pageIndex", "reportEnterPresentation", "action", "vcConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "handleThumbnail", "onConfigurationChanged", "isCurrentPortation", "orientation", "initScreenParams", "calculateWH", "", "Landroid/util/SizeF;", "enterPresentationMode", "bindPresentationFling", "adjustViewForImmersive", "enter", "exitPresentationMode", "setScrollListener", "listener", "setState", "getPageHeight", "position", "getPageCount", "getCurrentPage", "setCurrentPosition", "setPresentationPage", "loadPresentationPageView", "setPDFActionListener", "scrollToTargetPosition", "offset", "getViewHeight", "setListenerChange", "callBack", "generateOffsetPercent", "", "generateOffsetPercentV2", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/DrivePdfState$V2Offset;", "findMiddleItem", "getPageSize", "getPageResolution", "isPdfLoaded", "onBackPressed", "markContent", "markId", "contentAreaRates", "", "Landroid/graphics/RectF;", "color", "clickable", "countable", "updateContentMarkColor", "markArea", "updateAreaMarkColor", "removeMark", "removeAllMarks", "onCommitCommentRectF", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectF;", "onAreaClick", "onCommentInputPanelOpen", "onCommentInputPanelClose", "isBySend", "enterAreaMarker", "exitAreaMarker", "exportAreaMark", "addAreaPendingMark", "removeAreaPendingMark", "enterContentMarker", "exitContentMarker", "exportContentMark", "addContentPendingMark", "removeContentPendingMark", "deactivateContentPendingMark", "enterWholePageMarker", "exitWholePageMarker", "exportWholePageMark", "addWholePagePendingMark", "removeWholePagePendingMark", "deactivateWholePagePendingMark", "getCommentQuote", "updateAreaMarkerBackground", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFCtrlView extends FrameLayout implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a, m85.a {
    public static final int G = 0;
    public static final int H = 0;
    public boolean A;
    public a95.a B;
    public CommentRectLayout C;
    public com.bytedance.ee.bear.drive.biz.bubblemenu.d D;
    public xu5.b.a E;
    public final ca5.a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PDFThumbnailView f225220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PdfPresentationView f225221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PDFContentView f225222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f225223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PDFThumbnailSlider f225224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f225225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatImageView f225226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f225227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewOwner f225228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewOwner f225229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PDFCtrlViewModel f225230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DriveComponentRenderVM f225231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DriveBlockPreviewVM f225232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.preview.vc.connector.g f225233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c f225234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ExhibitionMode f225235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LruBitmapPool f225236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b f225237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f225238s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f225239t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f225240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f225241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Disposable f225242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DrivePdfState f225243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC3211a f225244y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public DriveConfigurationVM f225245z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f225246a = null;

        static {
            int[] r100 = new int[ExhibitionMode.values().length];
            r100[ExhibitionMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ExhibitionMode.PRESENTATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f225246a = r100;
        }
    }

    public static final class c implements PdfPresentationView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PDFCtrlView f225247a;

        public c(PDFCtrlView r100) {
            this.f225247a = r100;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView.b
        public final void onBackClick() {
            PDFCtrlView r100 = this.f225247a;
            int r101 = PDFCtrlView.G;
            if (r100.l() == false) goto L8;
            PDFCtrlView r102 = this.f225247a;
            r102.f225235p = ExhibitionMode.NORMAL;
            if (r102.f225237r == null) goto L9;
            r102.post(new x(r102));
            return;
        L9:
            return;
        }
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "PDFCtrlView";
    }

    static {
        G = ColorProtector.parseColor("#26FFC60A");
        H = ColorProtector.parseColor("#8CFFC60A");
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final DrivePdfState.V2Offset c() {
        DrivePdfState.V2Offset r100 = new DrivePdfState.V2Offset();
        int r101 = f();
        r100.pageNumber = r101 + 1;
        r100.pageOffsetTop = d(r101);
        return r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final int f() {
        PDFCtrlViewModel r100 = this.f225230k;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L6:
        return r100.findFirstVisiblePage();
    }

    public final TextView getBlockIndicatorFromXml() {
        KeyEvent.Callback r100 = this.f225223d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.block_indicator);
        this.f225223d = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final String getCommentQuote() {
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r100 = this.D;
        PDFCtrlViewModel r101 = null;
        if (r100 == null) goto L14;
        List<TTReaderSelectionInfo> r102 = r100.f222610a;
        if (r102 == null) goto L14;
        StringBuilder r103 = new StringBuilder();
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        String r105 = ((TTReaderSelectionInfo) r104.next()).selectedText;
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        r103.append(r105);
        goto L8
    L13:
        String r106 = r103.toString();
    L15:
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r107 = this.D;
        if (r107 == null) goto L22;
        List<TTReaderSelectionInfo> r108 = r107.f222610a;
        if (r108 == null) goto L22;
        TTReaderSelectionInfo r109 = (TTReaderSelectionInfo) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L22;
        int r110 = r109.pageIndex;
    L27:
        if (r110 >= 0) goto L35;
        return r106;
    L35:
        return JSON.toJSONString(new CommentQuote(com.bytedance.ee.bear.drive.biz.comment.data.c.f222740b.get(Integer.valueOf(R.string.Drive_Drive_QuotePage)), new String[]{String.valueOf(r110 + 1)}));
    L32:
        e = move-exception;
        tt5.a.f("CommentDataUtils", e, false);
        return "";
    L22:
        PDFCtrlViewModel r111 = this.f225230k;
        if (r111 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        r110 = r101.getCurrentPageIndex();
        goto L27
    L25:
        r101 = r111;
    L14:
        r106 = null;
        goto L15
    }

    public final TextView getIndicatorViewFromXml() {
        KeyEvent.Callback r100 = this.f225227h;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.indicator_view);
        this.f225227h = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getPageCount() {
        PDFCtrlViewModel r100 = this.f225230k;
        PDFCtrlViewModel r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L6:
        if (r100.m8326getPageCount().getValue() == null) goto L13;
        PDFCtrlViewModel r102 = this.f225230k;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        Integer r103 = r101.m8326getPageCount().getValue();
        Intrinsics.checkNotNull(r103);
        return r103.intValue();
    L10:
        r101 = r102;
        goto L11
    L13:
        return 0;
    }

    public final PDFContentView getPdfContentViewFromXml() {
        KeyEvent.Callback r100 = this.f225222c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.pdf_content_view);
        this.f225222c = (PDFContentView) r100;
    L6:
        return (PDFContentView) r100;
    }

    public final PDFThumbnailSlider getPdfThumbnailSliderFromXml() {
        KeyEvent.Callback r100 = this.f225224e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.pdf_thumbnail_slider);
        this.f225224e = (PDFThumbnailSlider) r100;
    L6:
        return (PDFThumbnailSlider) r100;
    }

    public final ImageView getPdfThumbnailToggleViewFromXml() {
        KeyEvent.Callback r100 = this.f225225f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.pdf_thumbnail_toggle_view);
        this.f225225f = (ImageView) r100;
    L6:
        return (ImageView) r100;
    }

    public final PDFThumbnailView getPdfThumbnailViewFromXml() {
        KeyEvent.Callback r100 = this.f225220a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.pdf_thumbnail_view);
        this.f225220a = (PDFThumbnailView) r100;
    L6:
        return (PDFThumbnailView) r100;
    }

    public final AppCompatImageView getPdfToWpsEditFromXml() {
        KeyEvent.Callback r100 = this.f225226g;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.pdf_to_wps_edit);
        this.f225226g = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final PdfPresentationView getPresentationViewFromXml() {
        KeyEvent.Callback r100 = this.f225221b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.presentation_view);
        this.f225221b = (PdfPresentationView) r100;
    L6:
        return (PdfPresentationView) r100;
    }

    public final void j() {
        tt5.a.h("PDFCtrlView", "exitAreaMarker.");
        CommentRectLayout r100 = this.C;
        if (r100 != null) goto L5;
    L10:
        r();
        KeyboardUtils.hideKeyboard(getContext());     // Catch: Throwable -> L13
    L15:
        ViewOwner r101 = this.f225229j;
        if (r101 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r101 = null;
    L18:
        PreviewViewModel r102 = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        if (r102 == null) goto L26;
        r102.liveInnerForcePortrait.postValue(Boolean.FALSE);
        MutableLiveData<CommentRectF> r103 = r102.liveInnerCommentSelected();
        if (r103 == null) goto L27;
        r103.postValue(null);
        return;
    L27:
        return;
    L26:
        return;
    L13:
        th = move-exception;
        tt5.a.e("PDFCtrlView", "exitAreaMarker, hideKeyboard error: ", th, false);
        goto L15
    L5:
        if (r100.q() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.j();
        goto L10
    }

    public final void k() {
        if (this.D != null) goto L5;
        return;
    L5:
        this.D = null;
        Intrinsics.checkNotNullParameter("ContentMarkId.PendingCreate", "markId");
        PDFCtrlViewModel r100 = this.f225230k;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L8:
        r100.removeMark("ContentMarkId.PendingCreate");
        ViewOwner r101 = this.f225229j;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r101 = null;
    L11:
        PreviewViewModel r102 = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        if (r102 == null) goto L17;
        MutableLiveData<CommentRectF> r103 = r102.liveInnerCommentSelected();
        if (r103 == null) goto L18;
        r103.postValue(null);
        return;
    L18:
        return;
    }

    public final boolean l() {
        tt5.a.h("PDFCtrlView", "exitPresentationMode currentMode=" + getCurrentMode());
        int r100 = 0;
        if (getCurrentMode() != ExhibitionMode.NORMAL) goto L5;
        return false;
    L5:
        getPresentationViewFromXml().setVisibility(8);
        ViewOwner r101 = this.f225229j;
        ViewOwner r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r101 = null;
    L8:
        PreviewViewModel r103 = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        MutableLiveData<Boolean> r104 = r103.liveInnerIsPresentationMode();
        Boolean r105 = Boolean.FALSE;
        r104.setValue(r105);
        r103.liveInnerVideoFullScreen().setValue(r105);
        r103.liveInnerForceFullScreen().setValue(r105);
        g(false);
        AppCompatImageView r106 = getPdfToWpsEditFromXml();
        ViewOwner r107 = this.f225229j;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L13:
        if (Intrinsics.areEqual(((PreviewViewModel) r102.viewModel(PreviewViewModel.class)).liveInnerEditModeSwitchActive().getValue(), Boolean.TRUE) == true) goto L16;
        r100 = 8;
    L16:
        r106.setVisibility(r100);
        return true;
    L11:
        r102 = r107;
        goto L13
    }

    public final void m() {
        DriveBlockPreviewVM r100 = this.f225232m;
        PDFCtrlViewModel r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r100 = null;
    L6:
        if (r100.isFromBlockPreview() == false) goto L12;
        DriveBlockPreviewVM r102 = this.f225232m;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r102 = null;
    L11:
        if (r102.getLiveBlockState().getValue() == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L12;
    L22:
        getIndicatorViewFromXml().setVisibility(8);
        return;
    L12:
        PDFCtrlViewModel r103 = this.f225230k;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        Integer r104 = r101.getRequestPwd().getValue();
        if (r104 == null) goto L22;
        if (r104.intValue() != 1) goto L22;
        getIndicatorViewFromXml().setVisibility(0);
        return;
    L15:
        r101 = r103;
        goto L16
    }

    public final void n() {
        DriveBlockPreviewVM r100 = this.f225232m;
        PDFCtrlViewModel r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r100 = null;
    L6:
        if (r100.isFromBlockPreview() == false) goto L12;
        DriveBlockPreviewVM r102 = this.f225232m;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r102 = null;
    L11:
        if (r102.getLiveBlockState().getValue() == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L12;
    L22:
        tt5.a.h("PDFCtrlView", "handleShowThumbnailIndicator, requestPwd: false");
        getPdfThumbnailToggleViewFromXml().setVisibility(8);
        getPdfThumbnailSliderFromXml().c(false);
        return;
    L12:
        PDFCtrlViewModel r103 = this.f225230k;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        Integer r104 = r101.getRequestPwd().getValue();
        if (r104 == null) goto L22;
        if (r104.intValue() != 1) goto L22;
        tt5.a.h("PDFCtrlView", "handleShowThumbnailIndicator, requestPwd: true");
        getPdfThumbnailToggleViewFromXml().setVisibility(0);
        getPdfThumbnailSliderFromXml().d(false);
        return;
    L15:
        r101 = r103;
        goto L16
    }

    @Override // m85.a
    public final void onRelease() {
        ViewOwner r100 = this.f225229j;
        PDFCtrlViewModel r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r100 = null;
    L5:
        PreviewViewModel r102 = (PreviewViewModel) r100.viewModel(PreviewViewModel.class);
        if (r102.isBlockViewChanging() == true) goto L55;
        ViewOwner r103 = this.f225229j;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r103 = null;
    L10:
        ((DrivePreviewAiResourceContextVM) r103.viewModel(DrivePreviewAiResourceContextVM.class)).clear();
        PDFCtrlViewModel r104 = this.f225230k;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r104 = null;
    L13:
        MutableLiveData<Boolean> r105 = r104.getBookLoaded();
        ViewOwner r106 = this.f225229j;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r106 = null;
    L16:
        r105.removeObservers(r106.lifecycleOwner());
        PDFCtrlViewModel r107 = this.f225230k;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r107 = null;
    L19:
        MutableLiveData<Boolean> r108 = r107.getShowThumbnail();
        ViewOwner r109 = this.f225229j;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r109 = null;
    L22:
        r108.removeObservers(r109.lifecycleOwner());
        PDFCtrlViewModel r110 = this.f225230k;
        if (r110 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r110 = null;
    L25:
        MutableLiveData<Integer> r111 = r110.getIndicator();
        ViewOwner r112 = this.f225229j;
        if (r112 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r112 = null;
    L28:
        r111.removeObservers(r112.lifecycleOwner());
        PDFCtrlViewModel r113 = this.f225230k;
        if (r113 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r113 = null;
    L31:
        MutableLiveData<Integer> r114 = r113.getRequestPwd();
        ViewOwner r115 = this.f225229j;
        if (r115 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r115 = null;
    L34:
        r114.removeObservers(r115.lifecycleOwner());
        PDFCtrlViewModel r116 = this.f225230k;
        if (r116 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        r101.dismissOutline();
        this.f225238s.clear();
        LruBitmapPool r117 = this.f225236q;
        if (r117 == null) goto L42;
        r117.clearMemory();
    L42:
        if (Intrinsics.areEqual(r102.liveInnerShowPresentationAction().getValue(), Boolean.TRUE) == false) goto L44;
        r102.liveInnerShowPresentationAction().postValue(Boolean.FALSE);
    L44:
        Disposable r118 = this.f225242w;
        if (r118 == null) goto L49;
        boolean r119 = true;
        if (r118.isDisposed() != true) goto L49;
    L50:
        if (r119 == true) goto L56;
        Disposable r120 = this.f225242w;
        if (r120 == null) goto L57;
        r120.dispose();
        return;
    L57:
        return;
    L56:
        return;
    L49:
        r119 = false;
        goto L50
    L37:
        r101 = r116;
        goto L38
    }

    public final void r() {
        tt5.a.h("PDFCtrlView", "removeCommentRectLayout");
        CommentRectLayout r100 = this.C;
        if (r100 == null) goto L20;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L16;
        ViewGroup r102 = null;
        if ((r101 instanceof ViewGroup) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L16;
        if ((r101 instanceof ViewGroup) == false) goto L14;
        r102 = (ViewGroup) r101;
    L14:
        if (r102 == null) goto L16;
        r102.removeView(r100);
    L16:
        xu5.b.a r103 = this.E;
        if (r103 == null) goto L21;
        r103.resetState();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getCurrentPage() {
        if (getCurrentMode() == ExhibitionMode.PRESENTATION) goto L5;
        PDFCtrlViewModel r100 = this.f225230k;
        PDFCtrlViewModel r101 = null;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L10:
        if (r100.getIndicator().getValue() == null) goto L17;
        PDFCtrlViewModel r102 = this.f225230k;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        Integer r103 = r101.getIndicator().getValue();
        Intrinsics.checkNotNull(r103);
        return r103.intValue() + 1;
    L14:
        r101 = r102;
        goto L15
    L17:
        return 0;
    L5:
        return getPresentationViewFromXml().getPageIndex();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getViewHeight() {
        return getPdfContentViewFromXml().getHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DriveComponentRenderVM r100 = this.f225231l;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("componentRenderVM");
        r100 = null;
    L6:
        if (r100.needBindReleaseListener() == true) goto L9;
        onRelease();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public ExhibitionMode getCurrentMode() {
        return this.f225235p;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final int a(int r100) {
        PDFCtrlViewModel r101 = this.f225230k;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L6:
        return (int) r101.getPageSizeF(r100 - 1).getHeight();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final boolean b(int r100) {
        if (getPresentationViewFromXml().getVisibility() != 0) goto L14;
        StringBuilder r101 = new StringBuilder("loadPresentationPageView position=");
        r101.append(r100);
        r101.append(" requestedOrientation1=");
        Activity r102 = (Activity) getContext();
        PDFCtrlViewModel r103 = null;
        if (r102 == null) goto L7;
        Integer r104 = Integer.valueOf(r102.getRequestedOrientation());
    L8:
        r101.append(r104);
        tt5.a.h("PDFCtrlView", r101.toString());
        PDFCtrlViewModel r105 = this.f225230k;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        this.f225242w = Flowable.just(Integer.valueOf(r100)).observeOn(Schedulers.single()).map(new f0(r100, this, h(r103.getPageSizeF(r100 - 1)))).observeOn(fo5.d.d()).subscribe(new g0(r100, this), h0.f225356a);
        return true;
    L11:
        r103 = r105;
        goto L12
    L7:
        r104 = null;
        goto L8
    L14:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final float d(int r100) {
        PDFCtrlViewModel r101 = this.f225230k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        float r102 = r101.getCurrentPageOffset(r100);
        tt5.a.h("PDFCtrlView", "generateOffsetPercent ret=" + r102);
        return r102;
    }

    public final void g(boolean r100) {
        ViewOwner r101 = this.f225229j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r101 = null;
    L5:
        ((DriveViewFullScreenVM) r101.viewModel(DriveViewFullScreenVM.class)).getImmersiveTitleTopState().postValue(Boolean.valueOf(r100));
    }

    public final int[] h(SizeF r100) {
        tt5.a.b("PDFCtrlView", "calculateWH, isPresentationMode: " + getCurrentMode() + ", screenWidth: " + this.f225239t + ", screenHeight: " + this.f225240u);
        double r101 = Math.min((((double) this.f225239t) * 1.0d) / ((double) r100.getWidth()), (((double) this.f225240u) * 1.0d) / ((double) r100.getHeight()));
        return new int[]{(int) (((double) r100.getWidth()) * r101), (int) (((double) r100.getHeight()) * r101)};
    }

    public final boolean i(int r110) {
        tt5.a.h("PDFCtrlView", "do enterPresentationMode. position: " + r110 + ", mIsPresentationMode: " + getCurrentMode() + ", mCurrentPage: " + getCurrentPage());
        if (getCurrentMode() != ExhibitionMode.PRESENTATION) goto L5;
        return false;
    L5:
        getPresentationViewFromXml().setVisibility(0);
        b(r110);
        PDFCtrlViewModel r111 = this.f225230k;
        ViewOwner r100 = null;
        if (r111 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r111 = null;
    L8:
        r111.updateClickTime(System.currentTimeMillis());
        PDFCtrlViewModel r112 = this.f225230k;
        if (r112 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r112 = null;
    L11:
        r112.getRenderView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        ViewOwner r113 = this.f225229j;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L15:
        PreviewViewModel r114 = (PreviewViewModel) r100.viewModel(PreviewViewModel.class);
        MutableLiveData<Boolean> r101 = r114.liveInnerIsPresentationMode();
        Boolean r102 = Boolean.TRUE;
        r101.setValue(r102);
        r114.liveInnerVideoFullScreen().setValue(r102);
        r114.liveInnerForceFullScreen().setValue(r102);
        getPdfToWpsEditFromXml().setVisibility(8);
        getPresentationViewFromXml().setBackClickListener(new c(this));
        g(true);
        return true;
    L14:
        r100 = r113;
        goto L15
    }

    public final void o(int r100) {
        int r101 = com.bytedance.ee.util.ui.n.v();
        int r102 = com.bytedance.ee.util.ui.n.t();
        boolean r103 = true;
        if (r100 == 1) goto L5;
    L7:
        r103 = false;
    L8:
        if (r103 == false) goto L10;
        this.f225239t = Math.min(r101, r102);
        this.f225240u = Math.max(r101, r102);
    L11:
        tt5.a.h("PDFCtrlView", "initScreenParams() called with: orientation = [" + r100 + "] w=" + this.f225239t + " h=" + this.f225240u);
        return;
    L10:
        int r104 = Math.max(r101, r102);
        this.f225239t = r104;
        this.f225240u = (r104 * r104) / Math.min(r101, r102);
        goto L11
    L5:
        if (getCurrentMode() == ExhibitionMode.PRESENTATION) goto L7;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        boolean r101 = true;
        if (r100 == null) goto L5;
        int r102 = r100.orientation;
    L6:
        o(r102);
        if (r100 == null) goto L9;
        int r103 = r100.orientation;
    L11:
        if (r103 == 1) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L18;
    L23:
        PDFCtrlViewModel r105 = this.f225230k;
        if (r105 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r105 = null;
    L27:
        if (Intrinsics.areEqual(r105.getShowThumbnail().getValue(), Boolean.TRUE) == false) goto L32;
        PDFThumbnailView r106 = getPdfThumbnailViewFromXml();
        if (r106 == null) goto L33;
        r106.f225285e.notifyDataSetChanged();
        return;
    L33:
        return;
    L32:
        return;
    L18:
        if (getPresentationViewFromXml().getVisibility() == 0) goto L21;
        r101 = false;
    L21:
        if (r101 == false) goto L23;
        com.bytedance.ee.util.ui.m.b(new i0(this), 200);
        goto L23
    L13:
        if (getCurrentMode() == ExhibitionMode.PRESENTATION) goto L15;
        r104 = true;
        goto L16
    L9:
        r103 = 1;
        goto L11
    L5:
        r102 = 1;
        goto L6
    }

    public final void s(String r100) {
        ViewOwner r101 = this.f225229j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r101 = null;
    L5:
        HashMap r102 = new HashMap();
        r102.put("action", r100);
        ((PreviewViewModel) r101.viewModel(PreviewViewModel.class)).liveInnerReportMsg().a(new com.bytedance.ee.bear.drive.view.preview.wrapper.a0(20, r102));
    }

    public final void setBlockIndicatorFromXml(TextView r100) {
        this.f225223d = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setCurrentPosition(int r100) {
        PDFCtrlViewModel r101 = this.f225230k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.turnToPage(r100 - 1);
    }

    public final void setDefaultEnterPresentation(boolean r100) {
        this.f225241v = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setExhibitionMode(ExhibitionMode r100) {
        int r101 = getCurrentPage();
        if (r100 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        l();
    L13:
        if (r100 == null) goto L16;
        this.f225235p = r100;
        return;
    L16:
        return;
    L9:
        if (r102 != 2) goto L13;
        i(r101);
        s("auto");
        goto L13
    L5:
        r102 = b.f225246a[r100.ordinal()];
        goto L7
    }

    public final void setIndicatorViewFromXml(TextView r100) {
        this.f225227h = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setListenerChange(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC3211a r100) {
        this.f225244y = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setPDFActionListener(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r100) {
        this.f225237r = r100;
    }

    public final void setPdfContentViewFromXml(PDFContentView r100) {
        this.f225222c = r100;
    }

    public final void setPdfThumbnailSliderFromXml(PDFThumbnailSlider r100) {
        this.f225224e = r100;
    }

    public final void setPdfThumbnailToggleViewFromXml(ImageView r100) {
        this.f225225f = r100;
    }

    public final void setPdfThumbnailViewFromXml(PDFThumbnailView r100) {
        this.f225220a = r100;
    }

    public final void setPdfToWpsEditFromXml(AppCompatImageView r100) {
        this.f225226g = r100;
    }

    public final void setPresentationViewFromXml(PdfPresentationView r100) {
        this.f225221b = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setScrollListener(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c r100) {
        this.f225234o = r100;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setState(DrivePdfState r100) {
        this.f225243x = r100;
    }

    public PDFCtrlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f225235p = ExhibitionMode.NORMAL;
        this.f225238s = new CompositeDisposable();
        this.F = new ca5.a();
        LayoutInflater.from(r100).inflate(R.layout.drive_pdf_ctrl_view, this);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final void e(int r100, int r101) {
        PDFCtrlViewModel r102 = this.f225230k;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L5:
        r102.scrollYOffset(r100, r101);
    }

    public final void t(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        PDFCtrlViewModel r102 = this.f225230k;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L5:
        r102.updateAreaMarkColor(r100, r101);
    }

    public final void u(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        PDFCtrlViewModel r102 = this.f225230k;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L5:
        r102.updateContentMarkColor(r100, r101);
    }

    public final void p(String r100, int r101, List<? extends RectF> r110, int r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        Intrinsics.checkNotNullParameter(r110, "contentAreaRates");
        PDFCtrlViewModel r114 = this.f225230k;
        if (r114 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r114 = null;
    L5:
        r114.markArea(r100, r101, r110, r111, r112, true);
    }

    public final void q(String r100, int r110, List<? extends RectF> r111, int r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        Intrinsics.checkNotNullParameter(r111, "contentAreaRates");
        PDFCtrlViewModel r101 = this.f225230k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.markContent(r100, r110, r111, r112, r113, r114);
    }
}
