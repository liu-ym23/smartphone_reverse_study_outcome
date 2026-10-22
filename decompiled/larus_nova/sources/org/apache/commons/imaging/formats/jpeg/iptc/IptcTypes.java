package org.apache.commons.imaging.formats.jpeg.iptc;

import faceverify.w;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum IptcTypes extends Enum<IptcTypes> implements IptcType {
    private static final /* synthetic */ IptcTypes[] $VALUES = null;
    public static final IptcTypes ACTION_ADVISED = null;
    public static final IptcTypes AUDIO_DURATION = null;
    public static final IptcTypes AUDIO_OUTCUE = null;
    public static final IptcTypes AUDIO_SAMPLING_RATE = null;
    public static final IptcTypes AUDIO_SAMPLING_RESOLUTION = null;
    public static final IptcTypes AUDIO_TYPE = null;
    public static final IptcTypes BYLINE = null;
    public static final IptcTypes BYLINE_TITLE = null;
    public static final IptcTypes CAPTION_ABSTRACT = null;
    public static final IptcTypes CATEGORY = null;
    public static final IptcTypes CITY = null;
    public static final IptcTypes CONTACT = null;
    public static final IptcTypes CONTENT_LOCATION_CODE = null;
    public static final IptcTypes CONTENT_LOCATION_NAME = null;
    public static final IptcTypes COPYRIGHT_NOTICE = null;
    public static final IptcTypes COUNTRY_PRIMARY_LOCATION_CODE = null;
    public static final IptcTypes COUNTRY_PRIMARY_LOCATION_NAME = null;
    public static final IptcTypes CREDIT = null;
    public static final IptcTypes DATE_CREATED = null;
    public static final IptcTypes DIGITAL_CREATION_DATE = null;
    public static final IptcTypes DIGITAL_CREATION_TIME = null;
    public static final IptcTypes EDITORIAL_UPDATE = null;
    public static final IptcTypes EDIT_STATUS = null;
    public static final IptcTypes EXPIRATION_DATE = null;
    public static final IptcTypes EXPIRATION_TIME = null;
    public static final IptcTypes FIXTURE_IDENTIFIER = null;
    public static final IptcTypes HEADLINE = null;
    public static final IptcTypes IMAGE_ORIENTATION = null;
    public static final IptcTypes IMAGE_TYPE = null;
    public static final IptcTypes KEYWORDS = null;
    public static final IptcTypes LANGUAGE_IDENTIFIER = null;
    public static final IptcTypes OBJECT_ATTRIBUTE_REFERENCE = null;
    public static final IptcTypes OBJECT_CYCLE = null;
    public static final IptcTypes OBJECT_DATA_PREVIEW_DATA = null;
    public static final IptcTypes OBJECT_DATA_PREVIEW_FILE_FORMAT = null;
    public static final IptcTypes OBJECT_DATA_PREVIEW_FILE_FORMAT_VERSION = null;
    public static final IptcTypes OBJECT_NAME = null;
    public static final IptcTypes OBJECT_TYPE_REFERENCE = null;
    public static final IptcTypes ORIGINAL_TRANSMISSION_REFERENCE = null;
    public static final IptcTypes ORIGINATING_PROGRAM = null;
    public static final IptcTypes PROGRAM_VERSION = null;
    public static final IptcTypes PROVINCE_STATE = null;
    public static final IptcTypes RASTERIZED_CAPTION = null;
    public static final IptcTypes RECORD_VERSION = null;
    public static final IptcTypes REFERENCE_DATE = null;
    public static final IptcTypes REFERENCE_NUMBER = null;
    public static final IptcTypes REFERENCE_SERVICE = null;
    public static final IptcTypes RELEASE_DATE = null;
    public static final IptcTypes RELEASE_TIME = null;
    public static final IptcTypes SOURCE = null;
    public static final IptcTypes SPECIAL_INSTRUCTIONS = null;
    public static final IptcTypes SUBJECT_REFERENCE = null;
    public static final IptcTypes SUBLOCATION = null;
    public static final IptcTypes SUPPLEMENTAL_CATEGORY = null;
    public static final IptcTypes TIME_CREATED = null;
    public static final IptcTypes URGENCY = null;
    public static final IptcTypes WRITER_EDITOR = null;
    public final String name;
    public final int type;

    static {
        IptcTypes r100 = new IptcTypes("RECORD_VERSION", 0, 0, "Record Version");
        RECORD_VERSION = r100;
        IptcTypes r101 = new IptcTypes("OBJECT_TYPE_REFERENCE", 1, 3, "Object Type Reference");
        OBJECT_TYPE_REFERENCE = r101;
        IptcTypes r102 = new IptcTypes("OBJECT_ATTRIBUTE_REFERENCE", 2, 4, "Object Attribute Reference");
        OBJECT_ATTRIBUTE_REFERENCE = r102;
        IptcTypes r103 = new IptcTypes("OBJECT_NAME", 3, 5, "Object Name");
        OBJECT_NAME = r103;
        IptcTypes r104 = new IptcTypes("EDIT_STATUS", 4, 7, "Edit Status");
        EDIT_STATUS = r104;
        IptcTypes r105 = new IptcTypes("EDITORIAL_UPDATE", 5, 8, "Editorial Update");
        EDITORIAL_UPDATE = r105;
        IptcTypes r110 = new IptcTypes("URGENCY", 6, 10, "Urgency");
        URGENCY = r110;
        IptcTypes r111 = new IptcTypes("SUBJECT_REFERENCE", 7, 12, "Subject Reference");
        SUBJECT_REFERENCE = r111;
        IptcTypes r112 = new IptcTypes("CATEGORY", 8, 15, "Category");
        CATEGORY = r112;
        IptcTypes r113 = new IptcTypes("SUPPLEMENTAL_CATEGORY", 9, 20, "Supplemental Category");
        SUPPLEMENTAL_CATEGORY = r113;
        IptcTypes r106 = new IptcTypes("FIXTURE_IDENTIFIER", 10, 22, "Fixture Identifier");
        FIXTURE_IDENTIFIER = r106;
        IptcTypes r114 = new IptcTypes("KEYWORDS", 11, 25, "Keywords");
        KEYWORDS = r114;
        IptcTypes r107 = new IptcTypes("CONTENT_LOCATION_CODE", 12, 26, "Content Location Code");
        CONTENT_LOCATION_CODE = r107;
        IptcTypes r108 = new IptcTypes("CONTENT_LOCATION_NAME", 13, 27, "Content Location Name");
        CONTENT_LOCATION_NAME = r108;
        IptcTypes r109 = new IptcTypes("RELEASE_DATE", 14, 30, "Release Date");
        RELEASE_DATE = r109;
        IptcTypes r115 = new IptcTypes("RELEASE_TIME", 15, 35, "Release Time");
        RELEASE_TIME = r115;
        IptcTypes r116 = new IptcTypes("EXPIRATION_DATE", 16, 37, "Expiration Date");
        EXPIRATION_DATE = r116;
        IptcTypes r117 = new IptcTypes("EXPIRATION_TIME", 17, 38, "Expiration Time");
        EXPIRATION_TIME = r117;
        IptcTypes r118 = new IptcTypes("SPECIAL_INSTRUCTIONS", 18, 40, "Special Instructions");
        SPECIAL_INSTRUCTIONS = r118;
        IptcTypes r119 = new IptcTypes("ACTION_ADVISED", 19, 42, "Action Advised");
        ACTION_ADVISED = r119;
        IptcTypes r120 = new IptcTypes("REFERENCE_SERVICE", 20, 45, "Reference Service");
        REFERENCE_SERVICE = r120;
        IptcTypes r121 = new IptcTypes("REFERENCE_DATE", 21, 47, "Reference Date");
        REFERENCE_DATE = r121;
        IptcTypes r122 = new IptcTypes("REFERENCE_NUMBER", 22, 50, "Reference Number");
        REFERENCE_NUMBER = r122;
        IptcTypes r123 = new IptcTypes("DATE_CREATED", 23, 55, "Date Created");
        DATE_CREATED = r123;
        IptcTypes r124 = new IptcTypes("TIME_CREATED", 24, 60, "Time Created");
        TIME_CREATED = r124;
        IptcTypes r125 = new IptcTypes("DIGITAL_CREATION_DATE", 25, 62, "Digital Creation Date");
        DIGITAL_CREATION_DATE = r125;
        IptcTypes r126 = new IptcTypes("DIGITAL_CREATION_TIME", 26, 63, "Digital Creation Time");
        DIGITAL_CREATION_TIME = r126;
        IptcTypes r127 = new IptcTypes("ORIGINATING_PROGRAM", 27, 65, "Originating Program");
        ORIGINATING_PROGRAM = r127;
        IptcTypes r128 = new IptcTypes("PROGRAM_VERSION", 28, 70, "Program Version");
        PROGRAM_VERSION = r128;
        IptcTypes r129 = new IptcTypes("OBJECT_CYCLE", 29, 75, "Object Cycle");
        OBJECT_CYCLE = r129;
        IptcTypes r130 = new IptcTypes("BYLINE", 30, 80, "By-line");
        BYLINE = r130;
        IptcTypes r131 = new IptcTypes("BYLINE_TITLE", 31, 85, "By-line Title");
        BYLINE_TITLE = r131;
        IptcTypes r132 = new IptcTypes("CITY", 32, 90, "City");
        CITY = r132;
        IptcTypes r133 = new IptcTypes("SUBLOCATION", 33, 92, "Sublocation");
        SUBLOCATION = r133;
        IptcTypes r134 = new IptcTypes("PROVINCE_STATE", 34, 95, "Province/State");
        PROVINCE_STATE = r134;
        IptcTypes r135 = new IptcTypes("COUNTRY_PRIMARY_LOCATION_CODE", 35, 100, "Country/Primary Location Code");
        COUNTRY_PRIMARY_LOCATION_CODE = r135;
        IptcTypes r136 = new IptcTypes("COUNTRY_PRIMARY_LOCATION_NAME", 36, 101, "Country/Primary Location Name");
        COUNTRY_PRIMARY_LOCATION_NAME = r136;
        IptcTypes r137 = new IptcTypes("ORIGINAL_TRANSMISSION_REFERENCE", 37, 103, "Original Transmission, Reference");
        ORIGINAL_TRANSMISSION_REFERENCE = r137;
        IptcTypes r138 = new IptcTypes("HEADLINE", 38, 105, "Headline");
        HEADLINE = r138;
        IptcTypes r139 = new IptcTypes("CREDIT", 39, 110, "Credit");
        CREDIT = r139;
        IptcTypes r140 = new IptcTypes("SOURCE", 40, 115, "Source");
        SOURCE = r140;
        IptcTypes r141 = new IptcTypes("COPYRIGHT_NOTICE", 41, 116, "Copyright Notice");
        COPYRIGHT_NOTICE = r141;
        IptcTypes r142 = new IptcTypes("CONTACT", 42, 118, "Contact");
        CONTACT = r142;
        IptcTypes r143 = new IptcTypes("CAPTION_ABSTRACT", 43, 120, "Caption/Abstract");
        CAPTION_ABSTRACT = r143;
        IptcTypes r144 = new IptcTypes("WRITER_EDITOR", 44, 122, "Writer/Editor");
        WRITER_EDITOR = r144;
        IptcTypes r145 = new IptcTypes("RASTERIZED_CAPTION", 45, 125, "Rasterized Caption");
        RASTERIZED_CAPTION = r145;
        IptcTypes r146 = new IptcTypes("IMAGE_TYPE", 46, 130, w.BLOB_ELEM_IMAGE_TYPE);
        IMAGE_TYPE = r146;
        IptcTypes r147 = new IptcTypes("IMAGE_ORIENTATION", 47, 131, "Image Orientation");
        IMAGE_ORIENTATION = r147;
        IptcTypes r148 = new IptcTypes("LANGUAGE_IDENTIFIER", 48, 135, "Language Identifier");
        LANGUAGE_IDENTIFIER = r148;
        IptcTypes r149 = new IptcTypes("AUDIO_TYPE", 49, 150, "Audio Type");
        AUDIO_TYPE = r149;
        IptcTypes r150 = new IptcTypes("AUDIO_SAMPLING_RATE", 50, 151, "Audio Sampling Rate");
        AUDIO_SAMPLING_RATE = r150;
        IptcTypes r151 = new IptcTypes("AUDIO_SAMPLING_RESOLUTION", 51, 152, "Audio Sampling Resolution");
        AUDIO_SAMPLING_RESOLUTION = r151;
        IptcTypes r152 = new IptcTypes("AUDIO_DURATION", 52, 153, "Audio Duration");
        AUDIO_DURATION = r152;
        IptcTypes r153 = new IptcTypes("AUDIO_OUTCUE", 53, 154, "Audio Outcue");
        AUDIO_OUTCUE = r153;
        IptcTypes r154 = new IptcTypes("OBJECT_DATA_PREVIEW_FILE_FORMAT", 54, 200, "Object Data Preview, File Format");
        OBJECT_DATA_PREVIEW_FILE_FORMAT = r154;
        IptcTypes r155 = new IptcTypes("OBJECT_DATA_PREVIEW_FILE_FORMAT_VERSION", 55, 201, "Object Data Preview, File Format Version");
        OBJECT_DATA_PREVIEW_FILE_FORMAT_VERSION = r155;
        IptcTypes r156 = new IptcTypes("OBJECT_DATA_PREVIEW_DATA", 56, 202, "Object Data Preview Data");
        OBJECT_DATA_PREVIEW_DATA = r156;
        $VALUES = new IptcTypes[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r114, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156};
    }

    public static IptcTypes[] values() {
        return (IptcTypes[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name + " (" + this.type + ")";
    }

    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.imaging.formats.jpeg.iptc.IptcType
    public int getType() {
        return this.type;
    }

    public static IptcType getUnknown(final int r100) {
        return new AnonymousClass1(r100);
    }

    public static IptcTypes valueOf(String r100) {
        return (IptcTypes) a.a(IptcTypes.class, r100);
    }

    private IptcTypes(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.name = r103;
    }
}
