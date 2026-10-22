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
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 Õ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Õ\u0001B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010g\u001a\u00020h2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020;2\u0006\u0010i\u001a\u00020P2\u0006\u0010@\u001a\u00020A2\u0006\u0010[\u001a\u00020\\J\b\u0010j\u001a\u00020hH\u0002J\b\u0010k\u001a\u00020hH\u0002J\b\u0010l\u001a\u00020hH\u0002J\b\u0010m\u001a\u00020hH\u0002J\b\u0010n\u001a\u00020hH\u0002J\u0010\u0010o\u001a\u00020h2\u0006\u0010p\u001a\u00020MH\u0002J\u000e\u0010q\u001a\u00020h2\u0006\u0010r\u001a\u00020PJ\b\u0010s\u001a\u00020hH\u0002J\b\u0010t\u001a\u00020hH\u0002J\b\u0010u\u001a\u00020hH\u0002J\b\u0010v\u001a\u00020hH\u0002J\u0010\u0010w\u001a\u00020h2\b\u0010x\u001a\u0004\u0018\u00010yJ\b\u0010z\u001a\u00020hH\u0014J\b\u0010~\u001a\u00020hH\u0016J\b\u0010\u007f\u001a\u00020hH\u0002J\t\u0010\u0080\u0001\u001a\u00020EH\u0016J\u001d\u0010\u0081\u0001\u001a\u00020h2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010E2\u0007\u0010\u0083\u0001\u001a\u00020MH\u0016J\u0014\u0010\u0084\u0001\u001a\u00020h2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010yH\u0002J\u0013\u0010\u0086\u0001\u001a\u00020h2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020hH\u0002J\u0015\u0010\u008a\u0001\u001a\u00020h2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0014J\u0012\u0010\u008b\u0001\u001a\u00020P2\u0007\u0010\u008c\u0001\u001a\u00020MH\u0002J\u0010\u0010\u008d\u0001\u001a\u00020h2\u0007\u0010\u008c\u0001\u001a\u00020MJ\u0013\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010p\u001a\u00030\u0090\u0001H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020P2\u0007\u0010\u0083\u0001\u001a\u00020MH\u0003J\t\u0010\u0092\u0001\u001a\u00020hH\u0002J\u0012\u0010\u0093\u0001\u001a\u00020h2\u0007\u0010\u0094\u0001\u001a\u00020PH\u0002J\t\u0010\u0095\u0001\u001a\u00020PH\u0002J\u0014\u0010\u0081\u0001\u001a\u00020h2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010EH\u0016J\u0014\u0010\u0096\u0001\u001a\u00020h2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010CH\u0016J\u0013\u0010\u0098\u0001\u001a\u00020h2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010\u0099\u0001\u001a\u00020M2\u0007\u0010\u009a\u0001\u001a\u00020MH\u0016J\t\u0010\u009b\u0001\u001a\u00020MH\u0016J\t\u0010\u009c\u0001\u001a\u00020MH\u0016J\u0012\u0010\u009d\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020MH\u0016J\u0012\u0010\u009e\u0001\u001a\u00020P2\u0007\u0010\u0083\u0001\u001a\u00020MH\u0016J\u0012\u0010\u009f\u0001\u001a\u00020P2\u0007\u0010\u009a\u0001\u001a\u00020MH\u0002J\u0014\u0010 \u0001\u001a\u00020h2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010IH\u0016J\u001b\u0010¡\u0001\u001a\u00020h2\u0007\u0010\u009a\u0001\u001a\u00020M2\u0007\u0010¢\u0001\u001a\u00020MH\u0016J\t\u0010£\u0001\u001a\u00020MH\u0016J\u0014\u0010¤\u0001\u001a\u00020h2\t\u0010¥\u0001\u001a\u0004\u0018\u00010VH\u0016J\u0013\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010\u009a\u0001\u001a\u00020MH\u0016J\n\u0010¨\u0001\u001a\u00030©\u0001H\u0016J\t\u0010ª\u0001\u001a\u00020MH\u0016J\u0011\u0010«\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0083\u0001\u001a\u00020MJ\u0011\u0010¬\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0083\u0001\u001a\u00020MJ\u0007\u0010\u00ad\u0001\u001a\u00020PJ\u0007\u0010®\u0001\u001a\u00020PJE\u0010¯\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010\u0083\u0001\u001a\u00020M2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u00012\u0007\u0010´\u0001\u001a\u00020M2\u0007\u0010µ\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020PJ\u0019\u0010·\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010´\u0001\u001a\u00020MJE\u0010¸\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010\u0083\u0001\u001a\u00020M2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u00012\u0007\u0010´\u0001\u001a\u00020M2\u0007\u0010µ\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020PJ\u0019\u0010¹\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020y2\u0007\u0010´\u0001\u001a\u00020MJ\u0010\u0010º\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020yJ\u0007\u0010»\u0001\u001a\u00020hJ\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001J\u0007\u0010¾\u0001\u001a\u00020PJ\u0007\u0010¿\u0001\u001a\u00020hJ\u0010\u0010À\u0001\u001a\u00020h2\u0007\u0010Á\u0001\u001a\u00020PJ\u0007\u0010Â\u0001\u001a\u00020hJ\u0007\u0010Ã\u0001\u001a\u00020hJ\n\u0010Ä\u0001\u001a\u0005\u0018\u00010½\u0001J\u0007\u0010Å\u0001\u001a\u00020hJ\u0007\u0010Æ\u0001\u001a\u00020hJ\u000f\u0010Ç\u0001\u001a\u00020h2\u0006\u0010a\u001a\u00020bJ\u0007\u0010È\u0001\u001a\u00020hJ\n\u0010É\u0001\u001a\u0005\u0018\u00010½\u0001J\u000f\u0010Ê\u0001\u001a\u00020h2\u0006\u0010a\u001a\u00020bJ\u0007\u0010Ë\u0001\u001a\u00020hJ\u0007\u0010Ì\u0001\u001a\u00020hJ\u0007\u0010Í\u0001\u001a\u00020hJ\u0007\u0010Î\u0001\u001a\u00020hJ\b\u0010Ï\u0001\u001a\u00030½\u0001J\u0010\u0010Ð\u0001\u001a\u00020h2\u0007\u0010\u0083\u0001\u001a\u00020MJ\u0007\u0010Ñ\u0001\u001a\u00020hJ\u0007\u0010Ò\u0001\u001a\u00020hJ\t\u0010Ó\u0001\u001a\u0004\u0018\u00010yJ\t\u0010Ô\u0001\u001a\u00020hH\u0002R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u0004\u0018\u00010/8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010{\u001a\u00020y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006Ö\u0001"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFCtrlView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer;", "Lcom/bytedance/ee/bear/drive/module/nativepreview/model/OnViewNeedReleaseListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pdfThumbnailViewFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;", "getPdfThumbnailViewFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;", "setPdfThumbnailViewFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailView;)V", "presentationViewFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/pdf/presentationview/PdfPresentationView;", "getPresentationViewFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/pdf/presentationview/PdfPresentationView;", "setPresentationViewFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/pdf/presentationview/PdfPresentationView;)V", "pdfContentViewFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView;", "getPdfContentViewFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView;", "setPdfContentViewFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFContentView;)V", "blockIndicatorFromXml", "Landroid/widget/TextView;", "getBlockIndicatorFromXml", "()Landroid/widget/TextView;", "setBlockIndicatorFromXml", "(Landroid/widget/TextView;)V", "pdfThumbnailSliderFromXml", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailSlider;", "getPdfThumbnailSliderFromXml", "()Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailSlider;", "setPdfThumbnailSliderFromXml", "(Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFThumbnailSlider;)V", "pdfThumbnailToggleViewFromXml", "Landroid/widget/ImageView;", "getPdfThumbnailToggleViewFromXml", "()Landroid/widget/ImageView;", "setPdfThumbnailToggleViewFromXml", "(Landroid/widget/ImageView;)V", "pdfToWpsEditFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getPdfToWpsEditFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setPdfToWpsEditFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "indicatorViewFromXml", "getIndicatorViewFromXml", "setIndicatorViewFromXml", "parentViewOwner", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;", "viewOwner", "viewModel", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/PDFCtrlViewModel;", "componentRenderVM", "Lcom/bytedance/ee/bear/drive/module/nativepreview/model/DriveComponentRenderVM;", "blockVM", "Lcom/bytedance/ee/bear/drive/view/preview/block/DriveBlockPreviewVM;", "vcReadyCallback", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/connector/IVCFollowReadyCallback;", "scrollListener", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer$ScrollListener;", "exhibitionMode", "Lcom/bytedance/ee/bear/drive/view/preview/pdf/ExhibitionMode;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "pdfActionListener", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer$IPDFActionListener;", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "presentationTargetWidth", "", "presentationTargetHeight", "defaultEnterPresentation", "", "presentationPageDis", "Lio/reactivex/disposables/Disposable;", "state", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/DrivePdfState;", "mListenerConfigurationChange", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/IPDFViewAbstractLayer$ConfigurationChangedCallBack;", "mInVc", "mDriveConfigurationVM", "Lcom/bytedance/ee/bear/drive/biz/preview/configuration/DriveConfigurationVM;", "disableIndicatorAnimFlag", "userComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "commentRectLayout", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectLayout;", "commentRectLayoutHelper", "Lcom/bytedance/ee/bear/drive/biz/comment/CommentRectLayoutHelper;", "selectionData", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/SelectionData;", "mStatusBarManager", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "onboardingController", "Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/onboarding/DrivePdfCommentAreaOnboardingController;", "init", "", "inVC", "initView", "initCommentRectLayout", "addCommentRectLayout", "removeCommentRectLayout", "bindView", "updateIndicator", "page", "setDefaultEnterPresentation", "enable", "checkDefaultExhibitionMode", "handleShowLeftTopIndicator", "handleShowThumbnailIndicator", "bindListener", "open", "password", "", "onDetachedFromWindow", "releaseKey", "getReleaseKey", "()Ljava/lang/String;", "onRelease", "removeObservers", "getCurrentMode", "setExhibitionMode", "mode", "pageIndex", "reportEnterPresentation", JSEventListener.ACTION, "vcConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "handleThumbnail", "onConfigurationChanged", "isCurrentPortation", "orientation", "initScreenParams", "calculateWH", "", "Landroid/util/SizeF;", "enterPresentationMode", "bindPresentationFling", "adjustViewForImmersive", "enter", "exitPresentationMode", "setScrollListener", "listener", "setState", "getPageHeight", "position", "getPageCount", "getCurrentPage", "setCurrentPosition", "setPresentationPage", "loadPresentationPageView", "setPDFActionListener", "scrollToTargetPosition", "offset", "getViewHeight", "setListenerChange", "callBack", "generateOffsetPercent", "", "generateOffsetPercentV2", "Lcom/bytedance/ee/bear/drive/biz/preview/vc/pdf/DrivePdfState$V2Offset;", "findMiddleItem", "getPageSize", "getPageResolution", "isPdfLoaded", "onBackPressed", "markContent", "markId", "contentAreaRates", "", "Landroid/graphics/RectF;", "color", "clickable", "countable", "updateContentMarkColor", "markArea", "updateAreaMarkColor", "removeMark", "removeAllMarks", "onCommitCommentRectF", "Lcom/bytedance/ee/bear/scaleimageview/areacomment/CommentRectF;", "onAreaClick", "onCommentInputPanelOpen", "onCommentInputPanelClose", "isBySend", "enterAreaMarker", "exitAreaMarker", "exportAreaMark", "addAreaPendingMark", "removeAreaPendingMark", "enterContentMarker", "exitContentMarker", "exportContentMark", "addContentPendingMark", "removeContentPendingMark", "deactivateContentPendingMark", "enterWholePageMarker", "exitWholePageMarker", "exportWholePageMark", "addWholePagePendingMark", "removeWholePagePendingMark", "deactivateWholePagePendingMark", "getCommentQuote", "updateAreaMarkerBackground", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFCtrlView extends FrameLayout implements com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a, m85.a {
    public static final int G = 0;
    public static final int H = 0;
    public boolean A;
    public a95.a B;
    public CommentRectLayout C;
    public com.bytedance.ee.bear.drive.biz.bubblemenu.d D;
    public xu5.b.a E;
    public final ca5.a F;
    public PDFThumbnailView a;
    public PdfPresentationView b;
    public PDFContentView c;
    public TextView d;
    public PDFThumbnailSlider e;
    public ImageView f;
    public AppCompatImageView g;
    public TextView h;
    public ViewOwner i;
    public ViewOwner j;
    public PDFCtrlViewModel k;
    public DriveComponentRenderVM l;
    public DriveBlockPreviewVM m;
    public com.bytedance.ee.bear.drive.biz.preview.vc.connector.g n;
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c o;
    public ExhibitionMode p;
    public LruBitmapPool q;
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r;
    public final CompositeDisposable s;
    public int t;
    public int u;
    public boolean v;
    public Disposable w;
    public DrivePdfState x;
    public com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC0155a y;
    public DriveConfigurationVM z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExhibitionMode.values().length];
            r0[ExhibitionMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ExhibitionMode.PRESENTATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements PdfPresentationView.b {
        public final /* synthetic */ PDFCtrlView a;

        public c(PDFCtrlView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView.b
        public final void onBackClick() {
            PDFCtrlView r0 = this.a;
            int r1 = PDFCtrlView.G;
            if (r0.l() == false) goto L8;
            PDFCtrlView r2 = this.a;
            r2.p = ExhibitionMode.NORMAL;
            if (r2.r == null) goto L9;
            r2.post(new x(r2));
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
        DrivePdfState.V2Offset r0 = new DrivePdfState.V2Offset();
        int r1 = f();
        r0.pageNumber = r1 + 1;
        r0.pageOffsetTop = d(r1);
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final int f() {
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.findFirstVisiblePage();
    }

    public final TextView getBlockIndicatorFromXml() {
        KeyEvent.Callback r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131364273);
        this.d = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final String getCommentQuote() {
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r0 = this.D;
        PDFCtrlViewModel r2 = null;
        if (r0 == null) goto L14;
        List<TTReaderSelectionInfo> r1 = r0.a;
        if (r1 == null) goto L14;
        StringBuilder r3 = new StringBuilder();
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        String r5 = ((TTReaderSelectionInfo) r4.next()).selectedText;
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r3.append(r5);
        goto L8
    L13:
        String r6 = r3.toString();
    L15:
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r7 = this.D;
        if (r7 == null) goto L22;
        List<TTReaderSelectionInfo> r8 = r7.a;
        if (r8 == null) goto L22;
        TTReaderSelectionInfo r9 = (TTReaderSelectionInfo) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L22;
        int r10 = r9.pageIndex;
    L27:
        if (r10 >= 0) goto L35;
        return r6;
    L35:
        return JSON.toJSONString(new CommentQuote((String) com.bytedance.ee.bear.drive.biz.comment.data.c.b.get(2131888440), new String[]{String.valueOf(r10 + 1)}));
    L32:
        e = move-exception;
        tt5.a.f("CommentDataUtils", e, false);
        return "";
    L22:
        PDFCtrlViewModel r11 = this.k;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        r10 = r2.getCurrentPageIndex();
        goto L27
    L25:
        r2 = r11;
    L14:
        r6 = null;
        goto L15
    }

    public final TextView getIndicatorViewFromXml() {
        KeyEvent.Callback r0 = this.h;
        if (r0 != null) goto L6;
        r0 = findViewById(2131375249);
        this.h = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getPageCount() {
        PDFCtrlViewModel r0 = this.k;
        PDFCtrlViewModel r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (r0.m372getPageCount().getValue() == null) goto L13;
        PDFCtrlViewModel r2 = this.k;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        Object r3 = r1.m372getPageCount().getValue();
        Intrinsics.checkNotNull(r3);
        return ((Number) r3).intValue();
    L10:
        r1 = r2;
        goto L11
    L13:
        return 0;
    }

    public final PDFContentView getPdfContentViewFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131382086);
        this.c = (PDFContentView) r0;
    L6:
        return (PDFContentView) r0;
    }

    public final PDFThumbnailSlider getPdfThumbnailSliderFromXml() {
        KeyEvent.Callback r0 = this.e;
        if (r0 != null) goto L6;
        r0 = findViewById(2131382087);
        this.e = (PDFThumbnailSlider) r0;
    L6:
        return (PDFThumbnailSlider) r0;
    }

    public final ImageView getPdfThumbnailToggleViewFromXml() {
        KeyEvent.Callback r0 = this.f;
        if (r0 != null) goto L6;
        r0 = findViewById(2131382088);
        this.f = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    public final PDFThumbnailView getPdfThumbnailViewFromXml() {
        RecyclerView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131382089);
        this.a = (PDFThumbnailView) r0;
    L6:
        return (PDFThumbnailView) r0;
    }

    public final AppCompatImageView getPdfToWpsEditFromXml() {
        AppCompatImageView r0 = this.g;
        if (r0 != null) goto L6;
        r0 = findViewById(2131382090);
        this.g = r0;
    L6:
        return r0;
    }

    public final PdfPresentationView getPresentationViewFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131382882);
        this.b = (PdfPresentationView) r0;
    L6:
        return (PdfPresentationView) r0;
    }

    public final void j() {
        tt5.a.h("PDFCtrlView", "exitAreaMarker.");
        CommentRectLayout r0 = this.C;
        if (r0 != null) goto L5;
    L10:
        r();
        KeyboardUtils.hideKeyboard(getContext());     // Catch: Throwable -> L13
    L15:
        ViewOwner r1 = this.j;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r1 = null;
    L18:
        PreviewViewModel r2 = (PreviewViewModel) r1.viewModel(PreviewViewModel.class);
        if (r2 == null) goto L26;
        r2.liveInnerForcePortrait.postValue(Boolean.FALSE);
        MutableLiveData<CommentRectF> r3 = r2.liveInnerCommentSelected();
        if (r3 == null) goto L27;
        r3.postValue(null);
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
        if (r0.q() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.j();
        goto L10
    }

    public final void k() {
        if (this.D != null) goto L5;
        return;
    L5:
        this.D = null;
        Intrinsics.checkNotNullParameter("ContentMarkId.PendingCreate", "markId");
        PDFCtrlViewModel r2 = this.k;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L8:
        r2.removeMark("ContentMarkId.PendingCreate");
        ViewOwner r1 = this.j;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r1 = null;
    L11:
        PreviewViewModel r3 = (PreviewViewModel) r1.viewModel(PreviewViewModel.class);
        if (r3 == null) goto L17;
        MutableLiveData<CommentRectF> r4 = r3.liveInnerCommentSelected();
        if (r4 == null) goto L18;
        r4.postValue(null);
        return;
    L18:
        return;
    }

    public final boolean l() {
        tt5.a.h("PDFCtrlView", "exitPresentationMode currentMode=" + getCurrentMode());
        int r2 = 0;
        if (getCurrentMode() != ExhibitionMode.NORMAL) goto L5;
        return false;
    L5:
        getPresentationViewFromXml().setVisibility(8);
        ViewOwner r0 = this.j;
        ViewOwner r3 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r0 = null;
    L8:
        PreviewViewModel r1 = (PreviewViewModel) r0.viewModel(PreviewViewModel.class);
        MutableLiveData<Boolean> r5 = r1.liveInnerIsPresentationMode();
        Boolean r6 = Boolean.FALSE;
        r5.setValue(r6);
        r1.liveInnerVideoFullScreen().setValue(r6);
        r1.liveInnerForceFullScreen().setValue(r6);
        g(false);
        AppCompatImageView r4 = getPdfToWpsEditFromXml();
        ViewOwner r7 = this.j;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L13:
        if (Intrinsics.areEqual(((PreviewViewModel) r3.viewModel(PreviewViewModel.class)).liveInnerEditModeSwitchActive().getValue(), Boolean.TRUE) == true) goto L16;
        r2 = 8;
    L16:
        r4.setVisibility(r2);
        return true;
    L11:
        r3 = r7;
        goto L13
    }

    public final void m() {
        DriveBlockPreviewVM r0 = this.m;
        PDFCtrlViewModel r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r0 = null;
    L6:
        if (r0.isFromBlockPreview() == false) goto L12;
        DriveBlockPreviewVM r1 = this.m;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r1 = null;
    L11:
        if (r1.getLiveBlockState().getValue() == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L12;
    L22:
        getIndicatorViewFromXml().setVisibility(8);
        return;
    L12:
        PDFCtrlViewModel r3 = this.k;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        Integer r4 = (Integer) r2.getRequestPwd().getValue();
        if (r4 == null) goto L22;
        if (r4.intValue() != 1) goto L22;
        getIndicatorViewFromXml().setVisibility(0);
        return;
    L15:
        r2 = r3;
        goto L16
    }

    public final void n() {
        DriveBlockPreviewVM r0 = this.m;
        PDFCtrlViewModel r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r0 = null;
    L6:
        if (r0.isFromBlockPreview() == false) goto L12;
        DriveBlockPreviewVM r1 = this.m;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r1 = null;
    L11:
        if (r1.getLiveBlockState().getValue() == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L12;
    L22:
        tt5.a.h("PDFCtrlView", "handleShowThumbnailIndicator, requestPwd: false");
        getPdfThumbnailToggleViewFromXml().setVisibility(8);
        getPdfThumbnailSliderFromXml().c(false);
        return;
    L12:
        PDFCtrlViewModel r3 = this.k;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        Integer r4 = (Integer) r2.getRequestPwd().getValue();
        if (r4 == null) goto L22;
        if (r4.intValue() != 1) goto L22;
        tt5.a.h("PDFCtrlView", "handleShowThumbnailIndicator, requestPwd: true");
        getPdfThumbnailToggleViewFromXml().setVisibility(0);
        getPdfThumbnailSliderFromXml().d(false);
        return;
    L15:
        r2 = r3;
        goto L16
    }

    @Override // m85.a
    public final void onRelease() {
        ViewOwner r0 = this.j;
        PDFCtrlViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r0 = null;
    L5:
        PreviewViewModel r1 = (PreviewViewModel) r0.viewModel(PreviewViewModel.class);
        if (r1.isBlockViewChanging() == true) goto L55;
        ViewOwner r3 = this.j;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r3 = null;
    L10:
        ((DrivePreviewAiResourceContextVM) r3.viewModel(DrivePreviewAiResourceContextVM.class)).clear();
        PDFCtrlViewModel r4 = this.k;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L13:
        MutableLiveData<Boolean> r5 = r4.getBookLoaded();
        ViewOwner r6 = this.j;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r6 = null;
    L16:
        r5.removeObservers(r6.lifecycleOwner());
        PDFCtrlViewModel r7 = this.k;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L19:
        MutableLiveData<Boolean> r8 = r7.getShowThumbnail();
        ViewOwner r9 = this.j;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r9 = null;
    L22:
        r8.removeObservers(r9.lifecycleOwner());
        PDFCtrlViewModel r10 = this.k;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L25:
        MutableLiveData<Integer> r11 = r10.getIndicator();
        ViewOwner r12 = this.j;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r12 = null;
    L28:
        r11.removeObservers(r12.lifecycleOwner());
        PDFCtrlViewModel r13 = this.k;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L31:
        MutableLiveData<Integer> r14 = r13.getRequestPwd();
        ViewOwner r16 = this.j;
        if (r16 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r16 = null;
    L34:
        r14.removeObservers(r16.lifecycleOwner());
        PDFCtrlViewModel r17 = this.k;
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L38:
        r2.dismissOutline();
        this.s.clear();
        LruBitmapPool r18 = this.q;
        if (r18 == null) goto L42;
        r18.clearMemory();
    L42:
        if (Intrinsics.areEqual(r1.liveInnerShowPresentationAction().getValue(), Boolean.TRUE) == false) goto L44;
        r1.liveInnerShowPresentationAction().postValue(Boolean.FALSE);
    L44:
        Disposable r19 = this.w;
        if (r19 == null) goto L49;
        boolean r20 = true;
        if (r19.isDisposed() != true) goto L49;
    L50:
        if (r20 == true) goto L56;
        Disposable r21 = this.w;
        if (r21 == null) goto L57;
        r21.dispose();
        return;
    L57:
        return;
    L56:
        return;
    L49:
        r20 = false;
        goto L50
    L37:
        r2 = r17;
        goto L38
    }

    public final void r() {
        tt5.a.h("PDFCtrlView", "removeCommentRectLayout");
        CommentRectLayout r0 = this.C;
        if (r0 == null) goto L20;
        ViewParent r1 = r0.getParent();
        if (r1 == null) goto L16;
        ViewGroup r3 = null;
        if ((r1 instanceof ViewGroup) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L16;
        if ((r1 instanceof ViewGroup) == false) goto L14;
        r3 = (ViewGroup) r1;
    L14:
        if (r3 == null) goto L16;
        r3.removeView(r0);
    L16:
        xu5.b.a r2 = this.E;
        if (r2 == null) goto L21;
        r2.resetState();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public int getCurrentPage() {
        if (getCurrentMode() == ExhibitionMode.PRESENTATION) goto L5;
        PDFCtrlViewModel r0 = this.k;
        PDFCtrlViewModel r1 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L10:
        if (r0.getIndicator().getValue() == null) goto L17;
        PDFCtrlViewModel r2 = this.k;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        Object r3 = r1.getIndicator().getValue();
        Intrinsics.checkNotNull(r3);
        return ((Number) r3).intValue() + 1;
    L14:
        r1 = r2;
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
        DriveComponentRenderVM r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("componentRenderVM");
        r0 = null;
    L6:
        if (r0.needBindReleaseListener() == true) goto L9;
        onRelease();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public ExhibitionMode getCurrentMode() {
        return this.p;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final int a(int r2) {
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return (int) r0.getPageSizeF(r2 - 1).getHeight();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final boolean b(int r4) {
        if (getPresentationViewFromXml().getVisibility() != 0) goto L14;
        StringBuilder r0 = new StringBuilder("loadPresentationPageView position=");
        r0.append(r4);
        r0.append(" requestedOrientation1=");
        Activity r1 = (Activity) getContext();
        PDFCtrlViewModel r2 = null;
        if (r1 == null) goto L7;
        Integer r3 = Integer.valueOf(r1.getRequestedOrientation());
    L8:
        r0.append(r3);
        tt5.a.h("PDFCtrlView", r0.toString());
        PDFCtrlViewModel r5 = this.k;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        this.w = Flowable.just(Integer.valueOf(r4)).observeOn(Schedulers.single()).map(new f0(r4, this, h(r2.getPageSizeF(r4 - 1)))).observeOn(fo5.d.d()).subscribe(new g0(r4, this), h0.a);
        return true;
    L11:
        r2 = r5;
        goto L12
    L7:
        r3 = null;
        goto L8
    L14:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final float d(int r3) {
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        float r4 = r0.getCurrentPageOffset(r3);
        tt5.a.h("PDFCtrlView", "generateOffsetPercent ret=" + r4);
        return r4;
    }

    public final void g(boolean r3) {
        ViewOwner r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r0 = null;
    L5:
        ((DriveViewFullScreenVM) r0.viewModel(DriveViewFullScreenVM.class)).getImmersiveTitleTopState().postValue(Boolean.valueOf(r3));
    }

    public final int[] h(SizeF r7) {
        tt5.a.b("PDFCtrlView", "calculateWH, isPresentationMode: " + getCurrentMode() + ", screenWidth: " + this.t + ", screenHeight: " + this.u);
        double r0 = Math.min((((double) this.t) * 1.0d) / ((double) r7.getWidth()), (((double) this.u) * 1.0d) / ((double) r7.getHeight()));
        return new int[]{(int) (((double) r7.getWidth()) * r0), (int) (((double) r7.getHeight()) * r0)};
    }

    public final boolean i(int r11) {
        tt5.a.h("PDFCtrlView", "do enterPresentationMode. position: " + r11 + ", mIsPresentationMode: " + getCurrentMode() + ", mCurrentPage: " + getCurrentPage());
        if (getCurrentMode() != ExhibitionMode.PRESENTATION) goto L5;
        return false;
    L5:
        getPresentationViewFromXml().setVisibility(0);
        b(r11);
        PDFCtrlViewModel r12 = this.k;
        ViewOwner r1 = null;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L8:
        r12.updateClickTime(System.currentTimeMillis());
        PDFCtrlViewModel r13 = this.k;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L11:
        r13.getRenderView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
        ViewOwner r14 = this.j;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L15:
        PreviewViewModel r16 = (PreviewViewModel) r1.viewModel(PreviewViewModel.class);
        MutableLiveData<Boolean> r0 = r16.liveInnerIsPresentationMode();
        Boolean r2 = Boolean.TRUE;
        r0.setValue(r2);
        r16.liveInnerVideoFullScreen().setValue(r2);
        r16.liveInnerForceFullScreen().setValue(r2);
        getPdfToWpsEditFromXml().setVisibility(8);
        getPresentationViewFromXml().setBackClickListener(new c(this));
        g(true);
        return true;
    L14:
        r1 = r14;
        goto L15
    }

    public final void o(int r6) {
        int r0 = com.bytedance.ee.util.ui.n.v();
        int r1 = com.bytedance.ee.util.ui.n.t();
        boolean r2 = true;
        if (r6 == 1) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == false) goto L10;
        this.t = Math.min(r0, r1);
        this.u = Math.max(r0, r1);
    L11:
        tt5.a.h("PDFCtrlView", "initScreenParams() called with: orientation = [" + r6 + "] w=" + this.t + " h=" + this.u);
        return;
    L10:
        int r3 = Math.max(r0, r1);
        this.t = r3;
        this.u = (r3 * r3) / Math.min(r0, r1);
        goto L11
    L5:
        if (getCurrentMode() == ExhibitionMode.PRESENTATION) goto L7;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        boolean r0 = true;
        if (r4 == null) goto L5;
        int r1 = r4.orientation;
    L6:
        o(r1);
        if (r4 == null) goto L9;
        int r5 = r4.orientation;
    L11:
        if (r5 == 1) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == true) goto L18;
    L23:
        PDFCtrlViewModel r7 = this.k;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L27:
        if (Intrinsics.areEqual((Boolean) r7.getShowThumbnail().getValue(), Boolean.TRUE) == false) goto L32;
        PDFThumbnailView r8 = getPdfThumbnailViewFromXml();
        if (r8 == null) goto L33;
        r8.e.notifyDataSetChanged();
        return;
    L33:
        return;
    L32:
        return;
    L18:
        if (getPresentationViewFromXml().getVisibility() == 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L23;
        com.bytedance.ee.util.ui.m.b(new i0(this), 200);
        goto L23
    L13:
        if (getCurrentMode() == ExhibitionMode.PRESENTATION) goto L15;
        r6 = true;
        goto L16
    L9:
        r5 = 1;
        goto L11
    L5:
        r1 = 1;
        goto L6
    }

    public final void s(String r4) {
        ViewOwner r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r0 = null;
    L5:
        HashMap r1 = new HashMap();
        r1.put(JSEventListener.ACTION, r4);
        ((PreviewViewModel) r0.viewModel(PreviewViewModel.class)).liveInnerReportMsg().a(new com.bytedance.ee.bear.drive.view.preview.wrapper.a0(20, r1));
    }

    public final void setBlockIndicatorFromXml(TextView r1) {
        this.d = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setCurrentPosition(int r2) {
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.turnToPage(r2 - 1);
    }

    public final void setDefaultEnterPresentation(boolean r1) {
        this.v = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setExhibitionMode(ExhibitionMode r4) {
        int r0 = getCurrentPage();
        if (r4 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        l();
    L13:
        if (r4 == null) goto L16;
        this.p = r4;
        return;
    L16:
        return;
    L9:
        if (r1 != 2) goto L13;
        i(r0);
        s("auto");
        goto L13
    L5:
        r1 = b.a[r4.ordinal()];
        goto L7
    }

    public final void setIndicatorViewFromXml(TextView r1) {
        this.h = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setListenerChange(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC0155a r1) {
        this.y = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setPDFActionListener(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r1) {
        this.r = r1;
    }

    public final void setPdfContentViewFromXml(PDFContentView r1) {
        this.c = r1;
    }

    public final void setPdfThumbnailSliderFromXml(PDFThumbnailSlider r1) {
        this.e = r1;
    }

    public final void setPdfThumbnailToggleViewFromXml(ImageView r1) {
        this.f = r1;
    }

    public final void setPdfThumbnailViewFromXml(PDFThumbnailView r1) {
        this.a = r1;
    }

    public final void setPdfToWpsEditFromXml(AppCompatImageView r1) {
        this.g = r1;
    }

    public final void setPresentationViewFromXml(PdfPresentationView r1) {
        this.b = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setScrollListener(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.c r1) {
        this.o = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public void setState(DrivePdfState r1) {
        this.x = r1;
    }

    public PDFCtrlView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.p = ExhibitionMode.NORMAL;
        this.s = new CompositeDisposable();
        this.F = new ca5.a();
        LayoutInflater.from(r2).inflate(2131560211, this);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a
    public final void e(int r2, int r3) {
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.scrollYOffset(r2, r3);
    }

    public final void t(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "markId");
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.updateAreaMarkColor(r2, r3);
    }

    public final void u(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "markId");
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.updateContentMarkColor(r2, r3);
    }

    public final void p(String r8, int r9, List<? extends RectF> r10, int r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "markId");
        Intrinsics.checkNotNullParameter(r10, "contentAreaRates");
        PDFCtrlViewModel r14 = this.k;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r14 = null;
    L5:
        r14.markArea(r8, r9, r10, r11, r12, true);
    }

    public final void q(String r9, int r10, List<? extends RectF> r11, int r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "markId");
        Intrinsics.checkNotNullParameter(r11, "contentAreaRates");
        PDFCtrlViewModel r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.markContent(r9, r10, r11, r12, r13, r14);
    }
}
